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

    public static void printResultProfit(String profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }

    public static void printMatchCountAndProfit(MatchCountPair matchCountPair) {
        for (Rank rank : Rank.values()) {
            printMatchCountWithBonusWhenSecond(rank);

            printMatchCount(rank.matchCount());
            pintProfit(rank.profit());
            printCount(matchCountPair.countByRank(rank));
        }
    }

    private static void printMatchCountWithBonusWhenSecond(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            printMatchCountWithBonus(rank.matchCount());
        }
    }

    private static void printMatchCountWithBonus(int matchCount) {
        System.out.print(matchCount + "개 일치, 보너스볼 일치");
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

    public static void printGenerateCount(GenerateCount auto, GenerateCount manual) {
        System.out.println("수동으로 " + manual.toString() + "개, 자동으로 " +  auto.toString() + "개를 구매했습니다.");
    }
}
