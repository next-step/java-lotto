package lotto.step3.view;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.Rank;

import java.util.Collections;

public final class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printOrderCount(int orderCount) {
        System.out.println(orderCount + "개를 구매했습니다.");
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

    public static void printWinningStatics(Lotteries lotteries, Lotto winningNumbers) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계");
        builder.append("\n");
        builder.append("----------");
        builder.append("\n");
        for (int count = 3; count <= 6; count++) {
            Rank rank = Rank.valueOf(count);
            builder.append(rank.getCountOfMatch());
            builder.append("개 일치(");
            builder.append(rank.getPrizeMoney());
            builder.append("원) - ");
            builder.append(lotteries.totalCountOfMatch(winningNumbers, count));
            builder.append("개");
            builder.append("\n");
        }
        System.out.print(builder);
    }


    public static void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }

}
