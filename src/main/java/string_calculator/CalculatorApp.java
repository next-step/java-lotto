package string_calculator;

public class CalculatorApp {
    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.parse(controller.scan());
            controller.print(controller.computes());
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
