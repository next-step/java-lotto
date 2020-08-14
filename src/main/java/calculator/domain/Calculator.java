package calculator.domain;

public class Calculator {

    public int calculate(String input) {
        InputManager inputManager = InputManager.of(input);

        Numbers numbers = inputManager.getNumbers();

        return numbers.add();
    }

}
