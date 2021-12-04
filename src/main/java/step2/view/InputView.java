package step2.view;

import step2.domain.WinningNumbers;
import step2.dto.Money;
import step2.dto.Ticket;
import step2.dto.WinningNumber;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static InputView INPUT_VIEW = new InputView();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ASK_BUY_PRICE = "구입금액을 입력해 주세요.";
    private static final String ANS_BUY_COUNT = "%d개를 구매했습니다.\n";
    private static final String ASK_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_DELIMITER = ", ";

    private InputView() {}

    public static InputView getInstance() {
        return INPUT_VIEW;
    }

    public Ticket inputBuyLotto() {
        System.out.println(ASK_BUY_PRICE);
        Money money = new Money(SCANNER.nextInt());

        SCANNER.nextLine();

        Ticket ticket = money.purchasedTicket();
        System.out.printf(ANS_BUY_COUNT, ticket.ticketCount());

        return ticket;
    }

    public WinningNumbers pickWinningNumber() {
        System.out.println(ASK_LAST_WEEK_WINNING_NUMBER);

        String inputText = SCANNER.nextLine();

        return Arrays.stream(inputText.split(WINNING_DELIMITER))
                .map(number -> new WinningNumber(number))
                .collect(Collectors.collectingAndThen(Collectors.toSet(), WinningNumbers::new));
    }
}
