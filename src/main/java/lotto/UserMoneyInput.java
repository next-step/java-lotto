package lotto;

public class UserMoneyInput {
    private Money money;

    public static UserMoneyInput from(String input) {
        UserMoneyInput userInput = new UserMoneyInput();

        validateBlankInput(input);
        userInput.setMoney(Integer.parseInt(input));

        return userInput;
    }

    public static void validateBlankInput(String input) {
        if (input == null || input.isBlank()) throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
    }

    private void setMoney(int amount) {
        this.money = new Money(amount);
    }

    public int getMoneyAmount() {
        return money.getAmount();
    }
}
