package lottery.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static long getInputPurchasePrice() {
        System.out.println(ViewMessages.INSTRUCTION_PURCHASE_PRICE);
        return Long.parseLong(scanner.nextLine());
    }

    public static String[] getLastWinnerTicketNumbers() {
        System.out.println(ViewMessages.INSTRUCTION_LOTTERY_WINNER_NUMBERS);
        return scanner.nextLine()
                .split(ViewMessages.COMMA);
    }
}
