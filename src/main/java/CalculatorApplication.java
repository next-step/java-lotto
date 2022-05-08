import domain.Operands;
import domain.Operators;
import java.util.Scanner;
import view.InputView;

public class CalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String[] userInput = inputView.getInput();
        Operators operators = new Operators(userInput);
        Operands operands = new Operands(userInput);
        System.out.println(Calculator.calculate(operators, operands));
    }
}
