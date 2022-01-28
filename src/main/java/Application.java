import domain.StringCalculator;
import util.ValidateInput;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();

        stringCalculator.add(InputView.readFormula());

//        System.out.println(validateInput.getYourInput());
    }
}
