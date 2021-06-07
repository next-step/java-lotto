package lottery.view;

import lottery.domain.BonusBall;
import lottery.domain.LotteryNumbers;
import lottery.domain.Money;
import lottery.domain.WinnerLottery;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reception {

    public static final String INPUT_DELIMITER = ",";

    public static BonusBall receiptBonusBall(WinnerLottery winnerLottery) {
        return new BonusBall(winnerLottery, receiptNumber());
    }

    public static Money receiptPrice() {
        return new Money(receiptNumber());
    }

    public static WinnerLottery receiptWinnerLottery(String input) {
        String[] splitInput = splitAndTrimInput(input);

        List<Integer> winnerLottery = new ArrayList<>();
        for (String number : splitInput) {
            winnerLottery.add(Integer.parseInt(number));
        }

        return new WinnerLottery(new LotteryNumbers(winnerLottery));
    }

    private static String[] splitAndTrimInput(String input) {
        return StringUtils.deleteWhitespace(input).split(INPUT_DELIMITER);
    }

    public static String receiptString() {
        Scanner scanner = makeScanner();
        return scanner.nextLine();
    }

    public static int receiptNumber() {
        Scanner scanner = makeScanner();
        return scanner.nextInt();
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }
}
