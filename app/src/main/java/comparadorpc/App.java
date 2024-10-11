package comparadorpc;

import comparadorpc.MainContainer;
import ui.HomeScreen;

public class App {

    public static void main(String[] args) throws InterruptedException {
        HomeScreen screen1 = new HomeScreen(new LogicMaster(new CompanyPolicy(3, 1, 1, 5, 6, 5, 1)), new LogicMaster(new CompanyPolicy(3, 1, 1, 5, 6, 5, 1)));
    }
}
