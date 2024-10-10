package comparadorpc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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

    public int animeWatchingHours = 16;

    public CompanyPolicy specificPolicy;
    WorkerLinkedList motherboardWorkers = new WorkerLinkedList();
    WorkerLinkedList cpuWorkers = new WorkerLinkedList();
    WorkerLinkedList ramWorkers = new WorkerLinkedList();
    WorkerLinkedList psuWorkers = new WorkerLinkedList();
    WorkerLinkedList graphicsWorkers = new WorkerLinkedList();
    WorkerLinkedList assemblyWorkers = new WorkerLinkedList();

    PiecesWarehouse myWarehouse = new PiecesWarehouse();
    ComputerWarehouse finishedWarehouse = new ComputerWarehouse();

    // Warehouse Stats
    public int motherBoardCapacity = 25;
    public int cpuCapacity = 20;
    public int ramCapacity = 55;
    public int psuCapacity = 35;
    public int gpuCapacity = 10;

    // Activity Stats
    public int currentDay = 0;
    public int workDays = 10;
    public int dayInSeconds = 0;
    public int initialMotherBoardWorkers = 0;
    public int initialCPUWorkers = 0;
    public int initialRAMWorkers = 0;
    public int initialpsuWorkers = 0;
    public int initialGraphicsWorkers = 0;
    public int initialAssemblyWorkers = 0;

    public void setDayInSeconds(int dayInSeconds) {
        this.dayInSeconds = dayInSeconds;
    }

    public void setComputerDeliverDeadline(int computerDeliverDeadline) {
        this.workDays = computerDeliverDeadline;
    }

    public void setInitialMotherBoardWorkers(int initialMotherBoardWorkers) {
        this.initialMotherBoardWorkers = initialMotherBoardWorkers;
    }

    public void setInitialCPUWorkers(int initialCPUWorkers) {
        this.initialCPUWorkers = initialCPUWorkers;
    }

    public void setInitialRAMWorkers(int initialRAMWorkers) {
        this.initialRAMWorkers = initialRAMWorkers;
    }

    public void setInitialpsuWorkers(int initialpsuWorkers) {
        this.initialpsuWorkers = initialpsuWorkers;
    }

    public void setInitialGraphicsWorkers(int initialGraphicsWorkers) {
        this.initialGraphicsWorkers = initialGraphicsWorkers;
    }

    public void setInitialAssemblyWorkers(int initialAssemblyWorkers) {
        this.initialAssemblyWorkers = initialAssemblyWorkers;
    }

    public int[] sendPiecesData() {
        return this.myWarehouse.packAndMail();
    }

    public int[] sendComputerData() {
        return this.finishedWarehouse.packAndMail();
    }

    public void updateWorkers(boolean modeSwitch, int pointer) {
        if (modeSwitch == true) {
            switch (pointer) {
                case 0:
                this.motherboardWorkers.append(new Worker(1, 2));
                break;
                case 1:
                    this.cpuWorkers.append(new Worker(1, 2));
                    break;
                case 2:
                    this.ramWorkers.append(new Worker(3,1));
                    break;
                case 3:
                    this.psuWorkers.append(new Worker(3,1));
                    break;
                case 4:
                    this.graphicsWorkers.append(new Worker(1, 3));
                    break;
                case 5:
                    this.assemblyWorkers.append(new Worker(true));
                    break;
                default:
                    break;
            }
        }
        else {
            switch (pointer) {
                case 0:
                    this.motherboardWorkers.popLast();
                    break;
                case 1:
                    this.cpuWorkers.popLast();
                    break;
                case 2:
                    this.ramWorkers.popLast();
                    break;
                case 3:
                    this.psuWorkers.popLast();
                    break;
                case 4:
                    this.graphicsWorkers.popLast();
                    break;
                case 5:
                    this.assemblyWorkers.popLast();
                    break;
                default:
                    break;
            }
        }
    }

    LogicMaster() {
        
    }
    
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
        private boolean hasPieces = false;
        public boolean isBuildingNormalPC = false;
        public boolean isBuildingGamingPC = false;
        
        public int timePast = 0;

        public Worker(int quantityReturned, int completionTime) {
            workReturn = quantityReturned;
            timeToFinish = completionTime;
        }

        public Worker(boolean assemblyActivator){
            isAssembly = true;
            workReturn = 1;
            timeToFinish = 2;
        }

        public int craft(){
            timePast += 1;
            if (timePast >= timeToFinish) {
                timePast = 0;
                if (isAssembly == true) {
                    hasPieces = false;
                    isBuildingNormalPC = false;
                    isBuildingGamingPC = false;
                }
                return workReturn;
            }
            else {
                return 0;
            }
        }

        public int assembleComputer(int identifier, int motherNum, int cpuNum, int ramNum, int psuNum, int gpuNum){
            if (hasPieces == false) {
                boolean retrieveAttempt = myWarehouse.retrieveFromWarehouse(motherNum, cpuNum, ramNum, psuNum, gpuNum);
                if (retrieveAttempt == true) {
                    switch (identifier) {
                        case 0:
                            isBuildingNormalPC = true;
                            isBuildingGamingPC = false;
                            hasPieces = true;
                            return craft();
                        case 1:
                            isBuildingNormalPC = false;
                            isBuildingGamingPC = true;
                            hasPieces = true;
                            return craft();
                        default:
                            return 0;
                    }
                }
                else {
                    return 0;
                }
            }
            else {
                return craft();
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

        int[] packAndMail(){
            int[] packedData = {availableMotherboards, availableCPUs, availableRAMs, availablePSUs, availableGPUs};
            return packedData;
        }

        void addToWarehouse(int numberOfItems, int storageID){
            switch (storageID) {
                case 0:
                    if (availableMotherboards + numberOfItems <= motherBoardCapacity){
                        availableMotherboards += numberOfItems;
                    }
                    else {
                        availableMotherboards = motherBoardCapacity;
                    }     
                    break;
                case 1:
                    if (availableCPUs + numberOfItems <= cpuCapacity){
                        availableCPUs += numberOfItems;
                    }
                    else {
                        availableCPUs = cpuCapacity;
                    }     
                    break;
                case 2:
                    if (availableRAMs + numberOfItems <= ramCapacity){
                        availableRAMs += numberOfItems;
                    }
                    else {
                        availableRAMs = ramCapacity;
                    }     
                    break;
                case 3:
                    if (availablePSUs + numberOfItems <= psuCapacity){
                        availablePSUs += numberOfItems;
                    }
                    else {
                        availablePSUs = psuCapacity;
                    }     
                    break;
                case 4:
                    if (availableGPUs + numberOfItems <= gpuCapacity){
                        availableGPUs += numberOfItems;
                    }
                    else {
                        availableGPUs = gpuCapacity;
                    }     
                    break;
            }
        }

        public boolean retrieveFromWarehouse(int motherNum, int cpuNum, int ramNum, int psuNum, int gpuNum ){
            if (availableMotherboards >= motherNum && availableCPUs >= cpuNum && availableRAMs >= ramNum && availablePSUs >= psuNum && availableGPUs >= gpuNum){
                availableMotherboards -= motherNum;
                availableCPUs -= cpuNum;
                availableRAMs -= ramNum;
                availablePSUs -= psuNum;
                availableGPUs -= gpuNum;
                return true;
            }
            else {
                return false;
            }
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

                master.myWarehouse.addToWarehouse(motherboardInput, 0);
                master.myWarehouse.addToWarehouse(cpuInput, 1);
                master.myWarehouse.addToWarehouse(ramInput, 2);
                master.myWarehouse.addToWarehouse(psuInput, 3);
                master.myWarehouse.addToWarehouse(gpuInput, 4);

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
        Semaphore accessToPieces;
        Semaphore accessToCompleted;
        LogicMaster master;
        AssemblyPipeline(Semaphore toPieces, Semaphore toCompleted, LogicMaster parent){
            master = parent;
            accessToPieces = toPieces;
            accessToCompleted = toCompleted;
        }
        
        @Override
        public void run() {
            try {
                accessToPieces.acquire();
                int completeStandardPC = 0;
                int completeGamingPC = 0;
                int nextProduction = master.specificPolicy.retrieveAndLoop();
                int[] productionObject;
                for (int i = 0; i < master.assemblyWorkers.length; i++){
                    if (master.assemblyWorkers.findAndRetrieve(i).hasPieces == true) {
                        if (master.assemblyWorkers.findAndRetrieve(i).isBuildingNormalPC == true){
                            completeStandardPC += master.assemblyWorkers.findAndRetrieve(i).assembleComputer(i, i, i, i, i, i);
                        }
                        else if (master.assemblyWorkers.findAndRetrieve(i).isBuildingGamingPC == true) {
                            completeGamingPC += master.assemblyWorkers.findAndRetrieve(i).assembleComputer(i, i, i, i, i, i);
                        }
                    }
                    else {
                        switch (nextProduction) {
                            case 0:
                                productionObject = master.specificPolicy.returnStandardPC();
                                completeStandardPC += master.assemblyWorkers.findAndRetrieve(i).assembleComputer(productionObject[0], productionObject[1], productionObject[2], productionObject[3],productionObject[4], productionObject[5]);
                                if (master.assemblyWorkers.findAndRetrieve(i).isBuildingNormalPC == true) {
                                    nextProduction = master.specificPolicy.retrieveAndLoop();
                                }
                                break;
                            case 1:
                                productionObject = master.specificPolicy.returnGamingPC();
                                completeGamingPC += master.assemblyWorkers.findAndRetrieve(i).assembleComputer(productionObject[0], productionObject[1], productionObject[2], productionObject[3],productionObject[4], productionObject[5]);
                                if (master.assemblyWorkers.findAndRetrieve(i).isBuildingGamingPC == true) {
                                    nextProduction = master.specificPolicy.retrieveAndLoop();
                                }
                                break;
                            default:
                                break;
                        }
                    }

                }
                accessToPieces.release();

                accessToCompleted.acquire();
                finishedWarehouse.addStandardPCs(completeStandardPC);
                finishedWarehouse.addGamerPCs(completeGamingPC);
                accessToCompleted.release();
            }
            catch (InterruptedException exc) {

            }
        }
    }

    private class ComputerWarehouse {
        int standardPCs = 0;
        int gamerPCs = 0;

        public void addStandardPCs(int quantity) {
            standardPCs += quantity;
        }
        public void addGamerPCs(int quantity) {
            gamerPCs += quantity;
        }

        public int[] packAndMail(){
            int[] packedData = {standardPCs, gamerPCs};
            return packedData;
        }

        public void shareInventory(){
            System.out.println("PCs Regulares: " + standardPCs);
            System.out.println("PCs Gamer: " + gamerPCs);
        }
    }

    private class ProjectManagerPipeline extends Thread {
        @Override
        public void run(){
            currentDay++;
        }
    }

    private class BossPipeline extends Thread {
    
    }

    public void simulateDay() throws InterruptedException { 
        this.specificPolicy = new CompanyPolicy(3, 1, 1, 5, 6, 5, 1);

        currentDay = 0;
        Semaphore piecesGatekeeper = new Semaphore(1);
        Semaphore finishedPCGatekeper = new Semaphore(1);
        
        for (int i = currentDay; i < workDays; i++) {
            PiecesPipeline piecesRunnable = new PiecesPipeline(piecesGatekeeper, this);
            ProjectManagerPipeline managerRunnable = new ProjectManagerPipeline();
            AssemblyPipeline builderPCRunnable = new AssemblyPipeline(piecesGatekeeper, finishedPCGatekeper, this);
            piecesRunnable.start();
            piecesRunnable.join();
            builderPCRunnable.start();
            managerRunnable.start();

            while (Thread.activeCount() > 1) {
                continue;
            }
        }

        // this.myWarehouse.showInventory();
        this.finishedWarehouse.shareInventory();
    }
    
    public void FileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            int[] valuesArray = readFileToArray(selectedFile);
            this.setDayInSeconds(valuesArray[0]);
            this.setComputerDeliverDeadline(valuesArray[1]);
            this.setInitialMotherBoardWorkers(valuesArray[2]);
            this.setInitialCPUWorkers(valuesArray[3]);
            this.setInitialRAMWorkers(valuesArray[4]);
            this.setInitialpsuWorkers(valuesArray[5]);
            this.setInitialGraphicsWorkers(valuesArray[6]);
            this.setInitialAssemblyWorkers(valuesArray[7]);
            JOptionPane.showMessageDialog(null, "�Carga Exitosa!");
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ning�n archivo.");
        }
    }

    public static int[] readFileToArray(File file) {
        int[] array = new int[8];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < array.length) {
                array[index] = Integer.parseInt(line.trim());
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: aseg�rate de que el archivo contiene solo n�meros enteros.");
        }
        return array;
    }
}

