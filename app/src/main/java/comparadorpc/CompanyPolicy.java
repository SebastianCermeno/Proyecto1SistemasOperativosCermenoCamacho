package comparadorpc;

public class CompanyPolicy {
    public LoopingLinkedList productionSchedule = new LoopingLinkedList();
    int motherboardsNeeded;
    int cpuNeeded;
    int ramNeeded;
    int psuNeeded;
    int gpuNeeded;
    public CompanyPolicy(int numberOfStandardPC, int numberOfGamingPC, int motherNum, int cpuNum, int ramNum, int psuNum, int gpuNum){
        for (int i = 0; i<numberOfStandardPC; i++) {
            productionSchedule.append(0);
        }
        for (int i = 0; i<numberOfGamingPC; i++) {
            productionSchedule.append(1);
        }

        motherboardsNeeded = motherNum;
        cpuNeeded = cpuNum;
        ramNeeded = ramNum;
        psuNeeded = psuNum;
        gpuNeeded = gpuNum;
    }

    public int[] returnStandardPC() {
        int[] standardPackage = {
            0,
            motherboardsNeeded,
            cpuNeeded,
            ramNeeded,
            psuNeeded,
            0
        };
        return standardPackage;
    }

    public int[] returnGamingPC() {
        int[] gamingPackage = {
            1,
            motherboardsNeeded,
            cpuNeeded,
            ramNeeded,
            psuNeeded,
            gpuNeeded
        };
        return gamingPackage;
    }

    public int retrieveAndLoop(){
        return productionSchedule.loop();
    }

    private class LoopingLinkedList {
        LinkedListNode root;
        LinkedListNode last;
        LinkedListNode lastAccess;
        int length = 0;
        private class LinkedListNode{
            int value;
            LinkedListNode next;
            LinkedListNode(int number){
                value = number;
            }
        }

        public int loop(){
            if (lastAccess == null) {
                lastAccess = root;
            }
            int returnTarget = lastAccess.value;
            lastAccess = lastAccess.next;
            return returnTarget;
        }

        public void append(int valueToInsert){
            if (root == null){
                root = new LinkedListNode(valueToInsert);
                root.next = root;
                last = root;
                lastAccess = root;
            }
            else {
                last.next = new LinkedListNode(valueToInsert);
                last = last.next;
                last.next = root;
            }
        }
    }
}
