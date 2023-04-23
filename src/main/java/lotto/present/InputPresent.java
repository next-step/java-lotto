package lotto.present;

import lotto.domain.Ticket;

import java.util.Scanner;

public class InputPresent {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요";
    private static final String PURCHASE_CONFIRM = "%s개를 구매했습니다";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요";
    private final Scanner scanner;
    public InputPresent() {
        scanner = new Scanner(System.in);
    }

    public int purchaseCount() {
        System.out.println(PURCHASE_AMOUNT);
        int count = scanner.nextInt() / 1000;
        System.out.printf(PURCHASE_CONFIRM, count);
        System.out.print(System.lineSeparator());
        return count;
    }

    public Ticket winningNumber() {
        System.out.println(WINNING_NUMBER);
        String s = scanner.nextLine();
        return new Ticket(s);
    }
}
