package step2;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private int amount;
    private String winningNumbers;

    public void askAmount() {
        System.out.println(LottoMessage.AMOUNT_MESSAGE_QUESTION);
        amount = Integer.parseInt(scanner.nextLine());
    }

    public int getAmount() {
        return amount;
    }

    public String askWinNumbers() {
        System.out.println(LottoMessage.WINNING_NUMBERS_QUESTION);
        winningNumbers = scanner.nextLine();
        return winningNumbers;
    }

    public String getWinNumbers() {
        return winningNumbers;
    }
}
