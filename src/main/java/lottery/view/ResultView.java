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
        System.out.println("- " + count);
    }

    private static void pintProfit(int profit) {
        System.out.print("(" + profit + ")");
    }

    private static void printMatchCount(int matchCount) {
        System.out.print(matchCount + "개 일치");
    }

    public static void printToStatisticWinner() {
        ResultView.printStatisticWinnerLottery();
        ResultView.printLines();
    }

    private static void printLines() {
        System.out.println("-------");
    }

    private static void printStatisticWinnerLottery() {
        System.out.println("당첨 통계");
    }

    public static void printToReceiptWinnerLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printLotteryNumbers(Lotteries lotteries) {
        for (Lottery lottery : lotteries.lotteries()) {
            printInitLotteryNumber();

            ImmutableList<LotteryNumber> lotteryNumbers = lottery.numbers().numbers();
            printLotteryNumbers(lotteryNumbers);

            printCloseLotteryNumbers();
        }
    }

    private static void printLotteryNumbers(ImmutableList<LotteryNumber> lotteryNumbers) {
        printLotteryNumbers(makeDisplayLotteryNumbers(lotteryNumbers));
    }

    private static List<String> makeDisplayLotteryNumbers(ImmutableList<LotteryNumber> lotteryNumbers) {
        List<String> displayNumbers = new ArrayList<>();

        for (LotteryNumber lotteryNumber : lotteryNumbers) {
            displayNumbers.add(lotteryNumber.toString());
        }

        return displayNumbers;
    }

    private static void printLotteryNumbers(List<String> displayNumbers) {
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
