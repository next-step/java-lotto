import static view.InputView.getInput;

import domain.UserInput;

public class CalculatorApplication {

    public static void main(String[] args) {
        new UserInput(getInput());
    }
}
