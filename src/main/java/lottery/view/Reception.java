package lottery.view;

import lottery.domain.BonusBall;
import lottery.domain.LotteryNumbers;
import lottery.domain.Money;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reception {

    public static final String INPUT_DELIMITER = ",";

    public static void printToReceiptManualLottery() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printToReceiptManualLotteryCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printToReceiptBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printToReceiptWinnerLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printToReceiptPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static BonusBall receiptBonusBall() {
        return new BonusBall(receiptNumber());
    }

    public static Money receiptPrice() {
        return new Money(receiptNumber());
    }

    public static List<LotteryNumbers> receiptManualLotteries(int receiptCountOfManual) {
        List<LotteryNumbers> lotteryNumbers = new ArrayList<>();

        for (int count = 0; count < receiptCountOfManual; count++) {
            lotteryNumbers.add(receiptAndMakeLotteryNumbers());
        }

        return lotteryNumbers;
    }

    public static LotteryNumbers receiptAndMakeLotteryNumbers() {
        return Reception.makeLotteryNumbers(Reception.receiptString());
    }

    public static LotteryNumbers makeLotteryNumbers(String input) {
        String[] splitInput = splitAndTrimInput(input);

        List<Integer> winnerLottery = new ArrayList<>();
        for (String number : splitInput) {
            winnerLottery.add(Integer.parseInt(number));
        }

        return new LotteryNumbers(winnerLottery);
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
