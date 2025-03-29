package views;

import data.Messages;
import domain.LottoGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBuyAmountGetTicketCount() {
        ResultView.println(Messages.ASK_BUY_AMOUNT);
        int ticketCount = scanner.nextInt() / LottoGame.TICKET_PRICE;
        System.out.printf(Messages.BUY_TICKET_COUNT_RESULT, ticketCount);
        return ticketCount;
    }

    public static List<Integer> inputWinNumbers() {
        ResultView.println(Messages.ASK_WIN_NUMBERS);

        String[] winNumbersStr = scanner.next().split(",");

        ResultView.printWinNumbers(winNumbersStr);

        return Arrays.stream(winNumbersStr).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int inputBonusNumbers() {

        ResultView.println(Messages.ASK_BONUS_NUMBERS);

        return scanner.nextInt();
    }
}
