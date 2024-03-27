package lottery.view;

import lottery.code.WinPrizeType;
import lottery.domain.Lotteries;
import lottery.domain.Lottery;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {

    public static void purchasedLotteryResult(Lotteries lotteries){
        lotteryCountResult(lotteries.lotteryCount());

        lotteries.lotteries().stream()
                        .forEach(lottery ->
                            System.out.println("[" + lotteryString(lottery) + "]")
                        );
    }

    private static void lotteryCountResult(Long lotteryCount){
        System.out.println(lotteryCount + "개를 구매했습니다.");
    }

    public static void winStatistics(Map<WinPrizeType, Long> winStatistics){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + optionalZero(winStatistics.get(WinPrizeType.THREE_MATCH)) + "개");
        System.out.println("4개 일치 (50000원)- " + optionalZero(winStatistics.get(WinPrizeType.FOUR_MATCH)) + "개");
        System.out.println("5개 일치 (1500000원)- " + optionalZero(winStatistics.get(WinPrizeType.FIVE_MATCH)) + "개");
        System.out.println("6개 일치 (2000000000원)- " + optionalZero(winStatistics.get(WinPrizeType.SIX_MATCH)) + "개");
    }

    private static Long optionalZero(Long value){
        return Objects.isNull(value) ? 0L : value;
    }

    public static void profitRate(BigDecimal winRate){
        System.out.println("총 수익률은 " + winRate + "입니다.");
    }

    private static String lotteryString(Lottery lottery){
        return lottery.lotteryNumbers().stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
