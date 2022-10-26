import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> inputList = inputView.getUserInputToStringList();
        Calculator calculator = new Calculator(inputList);
        int result = calculator.calculate().getNumber();
        System.out.println("result is... " + result);
    }
}
