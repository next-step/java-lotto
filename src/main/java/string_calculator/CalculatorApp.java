package string_calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.scan();
            controller.parse();
            controller.computes();
            controller.print();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
