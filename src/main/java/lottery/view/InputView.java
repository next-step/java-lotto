package lottery.view;

import lottery.domain.PurchasePrice;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    private static int ZERO = 0;

    private InputView() {
    }

    public static long getInputPurchasePrice() {
        System.out.println(ViewMessages.INSTRUCTION_PURCHASE_PRICE);
        return Long.parseLong(scanner.nextLine());
    }

    public static int getInputManualTicketCounts() {
        System.out.println(ViewMessages.INSTRUCTION_MANUAL_LOTTERY_TICKET_COUNTS);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String[]> getInputManualTicketsNumbers(PurchasePrice purchasePrice) {
        int manualTicketCounts = purchasePrice.getManualTicketCounts();
        if (manualTicketCounts != ZERO) {
            System.out.println(ViewMessages.INSTRUCTION_MANUAL_LOTTERY_TICKETS_NUMBERS);
        }
        return Stream.generate(() -> scanner.nextLine().split(ViewMessages.COMMA))
                .limit(manualTicketCounts)
                .collect(Collectors.toList());
    }

    public static String[] getInputLastWinnerTicketNumbers() {
        System.out.println(ViewMessages.INSTRUCTION_LOTTERY_WINNER_NUMBERS);
        return scanner.nextLine()
                .split(ViewMessages.COMMA);
    }

    public static int getInputBonusBallNumber() {
        System.out.println(ViewMessages.INSTRUCTION_BONUS_BALL_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }
}
