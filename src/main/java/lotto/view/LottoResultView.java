package lotto.view;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lotto.domain.Ranking;

public class LottoResultView {

    private static final int ZERO = 0;
    private static final int INSERT_INDEX_OF_BONUS_BALL = 5;

    private final StringBuilder stringBuilder = new StringBuilder();
    private int totalWinnerPrice = ZERO;


    public void finishGame(final Map<Ranking, Integer> totalResult, final int userPrice) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        final List<Ranking> rankings = new LinkedList<>(totalResult.keySet());
        Collections.sort(rankings);
        Collections.reverse(rankings);

        rankings.forEach(key ->
            process(key, totalResult.get(key)));

        printYield(userPrice);
    }

    private void printYield(final int userPrice) {
        stringBuilder.append("총 수익률은 ")
            .append(String.format("%.2f", (double) totalWinnerPrice / userPrice))
            .append("입니다.");
        System.out.println(stringBuilder);
    }

    private void process(final Ranking ranking, final Integer count) {
        if (ranking.isFail()) {
            return;
        }

        stringBuilder.append(ranking.getNormalSuccessNumber())
            .append("개 일치 ")
            .append("(")
            .append(ranking.getWinnerPrice())
            .append("원) - ")
            .append(count)
            .append("개");

        totalWinnerPrice += ranking.multiplyCountAndWinnerPrice(count);

        if (ranking.equals(Ranking.SECOND)) {
            stringBuilder.insert(INSERT_INDEX_OF_BONUS_BALL, ", 보너스 볼 일치");
        }

        System.out.println(stringBuilder);
        stringBuilder.setLength(ZERO);
    }

}
