package lotto.step3.view;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.Rank;

import java.util.Collections;
import java.util.Map;

public final class ResultView {

    public static final int LOTTO_BONUS_COUNT = 5;
    public static final int LOTTO_START_COUNT = 3;
    public static final int LOTTO_END_COUNT = 6;

    private ResultView() {
        throw new AssertionError();
    }

    public static void printOrderLottoNumber(Lotteries lotteries) {
        lotteries.getLotteries().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printOrderLottoCount(Lotteries lotteries) {
        System.out.println(lotteries.getLotteries().size() + "개를 구매했습니다.");
    }

    public static void printWinningStatics(Map<Integer, Integer> countOfMatch, boolean isMatchBonusBall, int totalSecond) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계");
        builder.append("\n");
        builder.append("----------");
        builder.append("\n");
        for (int count = LOTTO_START_COUNT; count <= LOTTO_END_COUNT; count++) {
            boolean isSecond = isSecondPrizeWinner(count, isMatchBonusBall);
            Rank rank = Rank.valueOf(count, isSecond);
            builder.append(count);
            builder.append("개 일치(");
            builder.append(rank.getPrizeMoney());
            builder.append("원) - ");
            int value = isSecond ? Rank.MISS.getCountOfMatch() : countOfMatch.get(count);
            builder.append(value);
            builder.append("개");
            builder.append("\n");
            printBonusBallStatics(builder, totalSecond, count);
        }
        System.out.print(builder);
    }

    public static void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }

    private static void printBonusBallStatics(StringBuilder builder, int totalSecondPrizeWinners, int count) {
        if (isBonusCount(count)) {
            builder.append(count);
            builder.append("개 일치, 보너스볼 일치 (");
            builder.append(Rank.SECOND.getPrizeMoney());
            builder.append("원) - ");
            builder.append(totalSecondPrizeWinners);
            builder.append("개");
            builder.append("\n");
        }
    }

    private static boolean isSecondPrizeWinner(int count, boolean isMatchBonusBall) {
        return isBonusCount(count) && isMatchBonusBall;
    }

    private static boolean isBonusCount(int count) {
        return count == LOTTO_BONUS_COUNT;
    }

}
