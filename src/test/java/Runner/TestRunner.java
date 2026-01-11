//package Runner;
//
//import Utilities.DriverFactory;
//import org.junit.runner.JUnitCore;
//
//public class TestRunner {
//
//    public static void main(String[] args) {
//        Thread chromeThread = new Thread(() -> {
//            DriverFactory.getInstance().setBrowser("chrome");
//            JUnitCore.runClasses(RunChrome.class);
//        });
//
//        Thread firefoxThread = new Thread(() -> {
//            DriverFactory.getInstance().setBrowser("firefox");
//            JUnitCore.runClasses(RunFirefox.class);
//        });
//        chromeThread.start();
//        firefoxThread.start();
//    }
//}
