package lotto.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Ranking;

public class LottoResultView {

    private static final int ZERO = 0;
    private static final int INSERT_INDEX_OF_BONUS_BALL = 5;

    private final StringBuilder stringBuilder = new StringBuilder();
    private final Map<Ranking, Integer> totalResult = new HashMap<>();
    private int totalWinnerPrice = ZERO;

    public LottoResultView() {
        initializeTotalResult();
    }

    private void initializeTotalResult() {
        totalResult.put(Ranking.FIRST, ZERO);
        totalResult.put(Ranking.SECOND, ZERO);
        totalResult.put(Ranking.THIRD, ZERO);
        totalResult.put(Ranking.FOURTH, ZERO);
        totalResult.put(Ranking.FIFTH, ZERO);
    }

    public void findWinner(final List<LottoNumber> winningNumbers, final Lottos userLottos,
        final LottoNumber bonusNumber) {

        final LottoCalculator lottoCalculator = LottoCalculator.getInstance();

        for (Lotto lotto : userLottos.getLottos()) {
            LottoResult lottoResult = lottoCalculator.countLotteryNumber(winningNumbers,
                lotto.getLottoNumbers(),
                bonusNumber);

            updateResult(Ranking.judgeRanking(lottoResult));
        }
    }

    private void updateResult(final Ranking ranking) {
        if (totalResult.containsKey(ranking)) {
            Integer currentCount = totalResult.get(ranking);
            totalResult.put(ranking, ++currentCount);
        }
    }

    public void finishGame(final int userPrice) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        final List<Ranking> rankings = new LinkedList<>(totalResult.keySet());
        Collections.sort(rankings);
        Collections.reverse(rankings);

        rankings.forEach(key ->
            process(key, totalResult.get(key)));

        printYield(userPrice);
    }

    private void printYield(int userPrice) {
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
