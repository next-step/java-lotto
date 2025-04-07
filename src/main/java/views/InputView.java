package views;

import data.Messages;
import domain.LottoGame;
import domain.LottoNumbers;
import domain.LottoGame;
import domain.LottoNumbers;
import domain.LottoGame;
import domain.LottoNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBuyAmountGetTicketCount() {
        ResultView.println(Messages.ASK_BUY_AMOUNT);
        int ticketCount = scanner.nextInt() / LottoGame.TICKET_PRICE;
        ResultView.printf(Messages.BUY_TICKET_COUNT_RESULT, ticketCount);
        return ticketCount;
    }

    public static LottoNumbers inputWinNumbers() {
        ResultView.println(Messages.ASK_WIN_NUMBERS);

        String[] winNumbersStr = scanner.next().split(",");

        ResultView.printWinNumbers(winNumbersStr);

        return new LottoNumbers(Arrays.stream(winNumbersStr).map(Integer::parseInt).collect(Collectors.toList()));
        return new LottoNumbers(Arrays.stream(winNumbersStr).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public static int inputBonusNumbers() {

        ResultView.println(Messages.ASK_BONUS_NUMBERS);

        return scanner.nextInt();
    }

    public static int inputBuyManualTicketCount() {

        ResultView.println(Messages.ASK_MANUAL_TICKET_COUNT);

        return scanner.nextInt();
    }

    public static String[] inputManualTicketNumbers(int manualTicketCount) {
        ResultView.println(Messages.ASK_MANUAL_TICKET_NUMBERS);
        String[] manualTicketNumbers = new String[manualTicketCount];
        for (int i = 0; i < manualTicketCount; i++) {
            manualTicketNumbers[i] = scanner.next();
        }
        return manualTicketNumbers;
    }
}
