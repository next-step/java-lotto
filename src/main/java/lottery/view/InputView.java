package lottery.view;

import lottery.domain.LotteryTicket;
import lottery.domain.StringParser;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static long getPurchasePrice() {
        System.out.println(ViewMessages.INSTRUCTION_PURCHASE_PRICE);
        return Long.parseLong(scanner.nextLine());
    }

    public static LotteryTicket getLastWinnerTicket() {
        System.out.println(ViewMessages.INSTRUCTION_LOTTERY_WINNER_NUMBERS);
        return new LotteryTicket(StringParser.parseString(scanner.nextLine()));
    }
}
