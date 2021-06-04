package lottery.view;

import com.google.common.collect.ImmutableList;
import lottery.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static final String LOTTERY_NUMBER_DELIMITER = ",";
    public static final String CLOSE_LOTTERY_NUMBERS = "]";
    public static final String OPEN_LOTTERY_NUMBERS = "[";
    public static final String OPEN_PROFIT = "(";
    public static final String CLOSE_PROFIT = ")";
    public static final String LINE_DELIMITER = "-";
    public static final String WHITE_SPACE = " ";
    public static final int START_INDEX = 0;
    public static final int LINE_DELIMITER_SIZE = 7;

    public static void printResultProfit(int profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }

    public static void printMatchCountAndProfit(MatchCountPair matchCountPair) {
        for (MatchCount matchCount : MatchCount.values()) {
            Rank rank = Rank.valueOf(matchCount);
            printMatchCount(rank.matchCount());
            pintProfit(rank.profit());
            printCount(matchCountPair.countByMatchCount(matchCount));
        }
    }

    private static void printCount(int count) {
        System.out.println(LINE_DELIMITER + WHITE_SPACE + count);
    }

    private static void pintProfit(int profit) {
        System.out.print(OPEN_PROFIT + profit + CLOSE_PROFIT);
    }

    private static void printMatchCount(int matchCount) {
        System.out.print(matchCount + "개 일치");
    }

    public static void printToStatisticWinner() {
        ResultView.printStatisticWinnerLottery();
        ResultView.printLinesAndLineBreak();
    }

    private static void printLinesAndLineBreak() {
        printLines();
        printLineBreak();
    }

    private static void printLines() {
        for (int count = START_INDEX; count < LINE_DELIMITER_SIZE; count++) {
            System.out.print(LINE_DELIMITER);
        }
    }

    private static void printLineBreak() {
        System.out.println();
    }

    private static void printStatisticWinnerLottery() {
        System.out.println("당첨 통계");
    }

    public static void printToReceiptWinnerLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printAllLotteryNumbers(List<LotteryNumbers> lotteries) {
        for (LotteryNumbers lottery : lotteries) {
            printInitLotteryNumber();

            printLotteryNumbers(lottery.numbers());

            printCloseLotteryNumbers();
        }
    }

    private static void printLotteryNumbers(ImmutableList<LotteryNumber> lotteryNumbers) {
        printDisplayLotteryNumbers(makeDisplayLotteryNumbers(lotteryNumbers));
    }

    private static List<String> makeDisplayLotteryNumbers(ImmutableList<LotteryNumber> lotteryNumbers) {
        List<String> displayNumbers = new ArrayList<>();

        for (LotteryNumber lotteryNumber : lotteryNumbers) {
            displayNumbers.add(lotteryNumber.toString());
        }

        return displayNumbers;
    }

    private static void printDisplayLotteryNumbers(List<String> displayNumbers) {
        System.out.print(StringUtils.join(displayNumbers, LOTTERY_NUMBER_DELIMITER));
    }

    private static void printInitLotteryNumber() {
        System.out.print(OPEN_LOTTERY_NUMBERS);
    }

    private static void printCloseLotteryNumbers() {
        System.out.println(CLOSE_LOTTERY_NUMBERS);
    }

    public static void printGenerateCount(GenerateCount generateCount) {
        System.out.println(generateCount.toString() + "개를 구매했습니다.");
    }

    public static void printToReceiptPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
