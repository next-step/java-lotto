package calculator;

import calculator.domain.UserInput;
import calculator.view.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.createInput();
        UserInput userInput = inputView.getInput();
        System.out.println(userInput.getInput());
    }
}
