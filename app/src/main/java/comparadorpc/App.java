package comparadorpc;

import comparadorpc.MainContainer;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MainContainer core = new MainContainer();
        LogicMaster puppetMaster = new LogicMaster();
        puppetMaster.executeSimulation();
        core.begin();
    }
}
