package comparadorpc;

import comparadorpc.MainContainer;
import ui.HomeScreen;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MainContainer core = new MainContainer();
        LogicMaster puppetMaster = new LogicMaster();
        HomeScreen screen1 = new HomeScreen(puppetMaster);
        puppetMaster.executeSimulation();
        core.begin();
    }
}
