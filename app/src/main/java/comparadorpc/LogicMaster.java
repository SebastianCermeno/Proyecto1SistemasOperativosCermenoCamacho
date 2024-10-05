package comparadorpc;

import java.util.concurrent.Semaphore;

public class LogicMaster {
    // Main Attributes (for config later)

    // Worker Stats
    public int numberOfWorkers = 12;
    public int motherBoardEfficiency = 2;
    public int cpuEfficiency = 2;
    public int ramEfficiency = 3;
    public int psuEfficiency = 3;
    public int graphicsEfficiency = 3;
    public int assemblyEfficiency = 3;

    public CompanyPolicy specificPolicy;
    WorkerLinkedList motherboardWorkers = new WorkerLinkedList();
    WorkerLinkedList cpuWorkers = new WorkerLinkedList();
    WorkerLinkedList ramWorkers = new WorkerLinkedList();
    WorkerLinkedList psuWorkers = new WorkerLinkedList();
    WorkerLinkedList graphicsWorkers = new WorkerLinkedList();
    WorkerLinkedList assemblyWorkers = new WorkerLinkedList();

    PiecesWarehouse myWarehouse = new PiecesWarehouse();

    // Warehouse Stats
    public int motherBoardCapacity = 25;
    public int cpuCapacity = 20;
    public int ramCapacity = 55;
    public int psuCapacity = 35;
    public int gpuCapacity = 10;

    // Activity Stats
    public int workDays = 10;

    // Inner Classes (Data Structures)
    private class WorkerLinkedList {
        WorkerNode root;
        WorkerNode last;
        public int length = 0;

        WorkerLinkedList(){

        }

        WorkerLinkedList(Worker starter){
            root = new WorkerNode(starter);
            last = root;
        }

        void append(Worker newValue){
            if (last != null) {
                last.next = new WorkerNode(newValue);
                last.next.previous = last;
                last = last.next;
            }
            else {
                root = new WorkerNode(newValue);
                last = root;
            }

            length += 1;
        }

        void popLast() {
            if (last != null) {
                last = last.previous;
                last.next = null;

                length -= 1;
            }
        }

        Worker findAndRetrieve(int indexOfItem){
            WorkerNode inspected = root;
            int iteratorCounter = 0;
            while (true) {
                if (iteratorCounter == indexOfItem) {
                    return inspected.value;
                }
                else {
                    if (inspected.next != null){
                        inspected = inspected.next;
                        iteratorCounter += 1;
                        continue;
                    }
                    else {
                        return null;
                    }
                }
            }
        }

        private class WorkerNode {
            Worker value;
            WorkerNode previous;
            WorkerNode next;
            WorkerNode(Worker nodeValue) {
                value = nodeValue;
            }

        }
    }

    // Inner Classes (Service Simulators)
    private class Worker {
        public int workReturn;
        public int timeToFinish;
        private boolean isAssembly = false;
        
        public int timePast = 0;

        public Worker(int quantityReturned, int completionTime) {
            workReturn = quantityReturned;
            timeToFinish = completionTime;
        }

        public int craft(){
            if (!isAssembly) {
                timePast += 1;
                if (timePast >= timeToFinish) {
                    timePast = 0;
                    return workReturn;
                }
                else {
                    return 0;
                }
            }
            else {
                return 0;
            }
        }
    }

    private class PiecesWarehouse {
        int availableMotherboards = 0;
        int availableCPUs = 0;
        int availableRAMs = 0;
        int availablePSUs = 0;
        int availableGPUs = 0;

        void cleanOut() {
            availableMotherboards = 0;
            availableCPUs = 0;
            availableRAMs = 0;
            availablePSUs = 0;
            availableGPUs = 0;
        }

        public void showInventory(){
            System.out.println(availableMotherboards);
            System.out.println(availableCPUs);
            System.out.println(availableRAMs);
            System.out.println(availablePSUs);
            System.out.println(availableGPUs);
        }
    }

    private class PiecesPipeline extends Thread {
        LogicMaster master;
        Semaphore warehouseController;

        boolean processesEnded = false;

        SpecificPipeline motherboardPipeline;
        SpecificPipeline cpuPipeline;
        SpecificPipeline ramPipeline;
        SpecificPipeline psuPipeline;
        SpecificPipeline gpuPipeline;

        int motherboardInput = 0;
        int cpuInput = 0;
        int ramInput = 0;
        int psuInput = 0;
        int gpuInput = 0;

        public PiecesPipeline(Semaphore warehousePController, LogicMaster parent){
            master = parent;
            warehouseController = warehousePController;

            motherboardPipeline = new SpecificPipeline(this, master.motherboardWorkers, 0);
            cpuPipeline = new SpecificPipeline(this, master.cpuWorkers, 1);
            ramPipeline = new SpecificPipeline(this, master.ramWorkers, 2);
            psuPipeline = new SpecificPipeline(this, master.psuWorkers, 3);
            gpuPipeline = new SpecificPipeline(this, master.graphicsWorkers, 4);
        }
        private void verifyComplete(){
            if (!motherboardPipeline.isAlive() && !cpuPipeline.isAlive() && !ramPipeline.isAlive() && !psuPipeline.isAlive() && !gpuPipeline.isAlive()) {
                processesEnded = true;
            }
        }

        private void resetInputs(){
            motherboardInput = 0;
            cpuInput = 0;
            ramInput = 0;
            psuInput = 0;
            gpuInput = 0;
        }

        @Override
        public void run(){
            try {
                resetInputs();
                warehouseController.acquire();

                motherboardPipeline.start();
                cpuPipeline.start();
                ramPipeline.start();
                psuPipeline.start();
                gpuPipeline.start();

                while (processesEnded == false){
                    verifyComplete();
                }

                master.myWarehouse.availableMotherboards += motherboardInput;
                master.myWarehouse.availableCPUs += cpuInput;
                master.myWarehouse.availableRAMs += ramInput;
                master.myWarehouse.availablePSUs += psuInput;
                master.myWarehouse.availableGPUs += gpuInput;

                warehouseController.release();
            }
            catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }

        private class SpecificPipeline extends Thread {
            PiecesPipeline generaPipeline;
            WorkerLinkedList myWorkers;
            int outputDirector;
            SpecificPipeline(PiecesPipeline parent, WorkerLinkedList workers, int reference){
                generaPipeline = parent;
                myWorkers = workers;
                outputDirector = reference;
            }

            @Override
            public void run() {
                int pipelineOutput = 0;
                for (int i = 0; i < myWorkers.length; i++) {
                    pipelineOutput += myWorkers.findAndRetrieve(i).craft();
                }

                switch (outputDirector) {
                    case 0:
                        generaPipeline.motherboardInput += pipelineOutput;
                        break;
                    case 1:
                        generaPipeline.cpuInput += pipelineOutput;
                        break;
                    case 2:
                        generaPipeline.ramInput += pipelineOutput;
                        break;
                    case 3:
                        generaPipeline.psuInput += pipelineOutput;
                        break;
                    case 4:
                        generaPipeline.gpuInput += pipelineOutput;
                        break;
                }
            }
        }
        
    }

    private class AssemblyPipeline extends Thread {

    }

    private class ProjectManagerPipeline extends Thread {

    }

    private class BossPipeline extends Thread {
    
    }

    public void executeSimulation() { 
        for (int i = 0; i < 3; i++) {
            this.motherboardWorkers.append(new Worker(1, 2));
        }

        for (int i = 0; i < 3; i++){
            this.cpuWorkers.append(new Worker(1, 2));
        }

        for (int i = 0; i < 2; i++) {
            this.ramWorkers.append(new Worker(3,1));
        }

        for (int i = 0; i < 2; i++) {
            this.psuWorkers.append(new Worker(3,1));
        }

        for (int i = 0; i < 2; i++) {
            this.graphicsWorkers.append(new Worker(1, 3));
        }

        Semaphore zetta = new Semaphore(1);
        
        for (int i = 0; i<3; i++) {
            PiecesPipeline scrimblis = new PiecesPipeline(zetta, this);
            scrimblis.start();

            while (scrimblis.isAlive() == true) {
                continue;
            }
        }

        this.myWarehouse.showInventory();
    }
}
