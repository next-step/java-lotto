package lotto.view;

import lotto.input.TicketPriceInput;
import lotto.input.WinningNumbersInput;

import java.util.Scanner;

public class InputView {

    private static final String FIRST_MSG = "구입금액을 입력해 주세요";
    private static final String TICKET_AMT_MSG = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_WINNING_NUMBER_MSG = "보너스 볼을 입력해 주세요.";

    public TicketPriceInput getTicketPriceInput() {
        System.out.println(FIRST_MSG);
        TicketPriceInput result;
        Scanner scanner = new Scanner(System.in);
        int priceInput = scanner.nextInt();
        result = new TicketPriceInput(priceInput);
        System.out.println(result.getTicketAmt() + TICKET_AMT_MSG);
        return result;
    }

    public WinningNumbersInput getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MSG);
        Scanner scanner = new Scanner(System.in);
        String winningNumbersString =  scanner.nextLine();
        System.out.println(BONUS_WINNING_NUMBER_MSG);
        String bonusWinningNumberString = scanner.nextLine();
        return new WinningNumbersInput(winningNumbersString, bonusWinningNumberString);
    }
}
