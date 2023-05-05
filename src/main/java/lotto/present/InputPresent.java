package lotto.present;

import lotto.domain.LottoNumber;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.exception.MinimumPurchaseShortageException;

import java.util.Scanner;

import static lotto.domain.Tickets.emptyTickets;

public class InputPresent {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요";
    private static final String PURCHASE_CONFIRM = "총 %s개를 구매합니다%s";
    private static final String PURCHASE_MANUAL = "수동으로 구매할 로또 수를 입력해 주세요%s";
    private static final String MANUAL_NUMBERS = "수동으로 구매할 구매할 번호를 입력해 주세요";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요";
    private final Scanner scanner;

    public InputPresent() {
        scanner = new Scanner(System.in);
    }

    public int purchaseCount() {
        System.out.println(PURCHASE_AMOUNT);
        int count = Integer.parseInt(scanner.nextLine()) / 1000;
        System.out.printf(PURCHASE_CONFIRM, count,System.lineSeparator());
        MinimumPurchaseCountValidate(count);
        return count;
    }

    private void MinimumPurchaseCountValidate(int count) {
        if(count <= 0) {
            throw new MinimumPurchaseShortageException();
        }
    }

    public Ticket winningNumbers() {
        System.out.println(WINNING_NUMBER);
        String s = scanner.nextLine();
        System.out.println(s);
        return new Ticket(s);
    }

    public LottoNumber bonusNumber() {
        System.out.println(BONUS_NUMBER);
        String s = scanner.nextLine();
        System.out.println(s);
        return LottoNumber.of(Integer.parseInt(s));
    }

    public Tickets manualPurchases() {
        Tickets tickets = emptyTickets();
        System.out.printf(PURCHASE_MANUAL, System.lineSeparator());
        int iter = Integer.parseInt(scanner.nextLine());
        System.out.printf("수동으로 %d 개를 구매합니다%s", iter, System.lineSeparator());
        for (int i = 0; i < iter; i++) {
            tickets.add(manualPurchase(scanner.nextLine()));
        }
        return tickets;
    }


    private Ticket manualPurchase(String nextLine) {
        System.out.println(MANUAL_NUMBERS);
        Ticket ticket = new Ticket(nextLine);
        System.out.printf("수동 구매 내역 확인 : %s%s", ticket, System.lineSeparator());
        return ticket;
    }
}
