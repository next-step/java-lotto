import static domain.Tokenizer.splitToken;
import static domain.formula.Formula.getFormulaByInput;
import static view.InputView.getInput;

import domain.UserInput;
import domain.formula.Formula;

public class CalculatorApplication {

    public static void main(String[] args) {
        getResult(new UserInput(getInput()));
    }

    private static void getResult(UserInput userInput) {
        Formula formulaByInput = getFormulaByInput(splitToken(userInput.getUserInput()));
    }
}
