package lotto.step3.view;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.Rank;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ResultView {

    public static final int LOTTO_BONUS_COUNT = 5;

    private ResultView() {
        throw new AssertionError();
    }

    public static void printOrderLottoCount(Lotteries lotteries) {
        System.out.println(lotteries.getLotteries().size() + "개를 구매했습니다.");
    }

    public static void printOrderLottoNumber(Lotteries lotteries) {
        lotteries.getLotteries()
                .stream()
                .map(Lotto::getNumbers)
                .forEach(s -> {
                    Collections.sort(s);
                    System.out.println(s);
                });
        System.out.println();
    }

    public static void printWinningStatics(Map<Integer, Integer> countOfMatch, boolean isMatchBonusBall, int totalSecond) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계");
        builder.append("\n");
        builder.append("----------");
        builder.append("\n");
        for (int count = 3; count <= 6; count++) {
            boolean bonus = isBonus(count, isMatchBonusBall);
            Rank rank = Rank.valueOf(count, bonus);
            builder.append(count);
            builder.append("개 일치(");
            builder.append(rank.getPrizeMoney());
            builder.append("원) - ");
            int value = bonus ? 0 : countOfMatch.get(count);
            builder.append(value);
            builder.append("개");
            builder.append("\n");
            printBonusBallStatics(builder, totalSecond, count);
        }
        System.out.print(builder);
    }

    private static void printBonusBallStatics(StringBuilder builder, int totalSecond, int count) {
        if (count == LOTTO_BONUS_COUNT) {
            builder.append(count);
            builder.append("개 일치, 보너스볼 일치 (");
            builder.append(Rank.SECOND.getPrizeMoney());
            builder.append("원) - ");
            builder.append(totalSecond);
            builder.append("개");
            builder.append("\n");
        }
    }

    private static boolean isBonus(int count, boolean isMatchBonusBall) {
        return count == LOTTO_BONUS_COUNT && isMatchBonusBall;
    }

    public static void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }

}
