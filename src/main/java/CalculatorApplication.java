import static domain.Tokenizer.splitToken;
import static view.InputView.getInput;

import domain.Formula;
import domain.UserInput;

public class CalculatorApplication {

    public static void main(String[] args) {
        getResult(new UserInput(getInput()));
    }

    private static void getResult(UserInput userInput) {
        new Formula(splitToken(userInput.getUserInput()));
    }
}
