package lotto.step1.calculator;

public class UserInput {
    private final String userInputString;

    public UserInput(final String userInputString) {
        this.userInputString = userInputString;
    }

    public String[] split() {
        return userInputString.split(" ");
    }
}
