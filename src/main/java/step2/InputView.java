package step2;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private int amount;
    private int bounus;
    private String winningNumbers;

    public int askAmount() {
        System.out.println(LottoMessage.AMOUNT_MESSAGE_QUESTION);
        amount = Integer.parseInt(scanner.nextLine());
        return amount;
    }

    public int getAmount() {
        return amount;
    }

    public String askWinNumbers() {
        System.out.println(LottoMessage.WINNING_NUMBERS_QUESTION);
        winningNumbers = scanner.nextLine();
        return winningNumbers;
    }

    public int askBonus() {
        System.out.println(LottoMessage.BONUS_MESSAGE_QUESTION);
        bounus = Integer.parseInt(scanner.nextLine());
        return bounus;
    }


    public int getBonus() {
        return bounus;
    }

}
