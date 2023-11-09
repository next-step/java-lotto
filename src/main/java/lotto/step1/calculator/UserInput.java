package lotto.step1.calculator;

public class UserInput {
    private final String userInputString;

    public UserInput(final String userInputString) {
        verifyUserInputString(userInputString);

        this.userInputString = userInputString;
    }

    public String[] split() {
        return userInputString.split(" ");
    }

    private void verifyUserInputString(final String userInputString) {
        if (userInputString == null || userInputString.isEmpty()) {
            throw new IllegalArgumentException("입력은 null 혹은 빈 공백일 수 없습니다.");
        }
    }
}
