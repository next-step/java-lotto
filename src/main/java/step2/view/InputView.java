package step2.view;

import step2.Constant;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private int amount;

    public void askAmount() {
        System.out.println(Constant.AMOUNT_MESSAGE_QUESTION);
        amount = Integer.parseInt(scanner.nextLine());
    }

    public int getAmount() {
        return amount;
    }

    public int askBonusNumber() {
        System.out.println(Constant.BONUS_NUMBERS_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

    public String askWinningNumbers() {
        System.out.println(Constant.WINNING_NUMBERS_QUESTION);
        String winningNumbers = scanner.nextLine();

        return winningNumbers;
    }

}
