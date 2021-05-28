package lotto.view;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKET_COUNT_MESSSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_TICKET_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public long inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return scanner.nextLong();

    }

    public int inputManualTicketCount() {
        System.out.println(INPUT_MANUAL_TICKET_COUNT_MESSSAGE);
        return scanner.nextInt();
    }

    public List<LottoTicket> inputManualLottoTicket(int manualTicketCount) {
        scanner.nextLine(); // clear scanner buffer
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        System.out.println(INPUT_MANUAL_TICKET_MESSAGE);
        for (int i = 0; i < manualTicketCount; i++) {
            manualLottoTickets.add(new LottoTicket(scanner.nextLine()));
        }

        return manualLottoTickets;
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return scanner.nextLine();
    }

    public int inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL);
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
