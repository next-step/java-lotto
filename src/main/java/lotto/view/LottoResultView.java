package lotto.view;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Ranking;

public class LottoResultView {

    private static final int ZERO = 0;
    private static final String LOTTO_STATISTICS_MESSAGE = "당첨 통계";
    private static final String HYPHEN_MESSAGE = "---------";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 ";
    private static final String FINISH_MESSAGE = "입니다.";
    private static final String OPENING_PARENTHESIS = "(";
    private static final String MATCH_AMOUNT_MESSAGE = "개 일치";
    private static final String BONUS_BALL_MATCH_MESSAGE = "보너스 볼 일치";
    private static final String WON_MESSAGE = "원) - ";
    private static final String AMOUNT_MESSAGE = "개";
    private static final String SPACE = " ";
    private static final String COMMA = ",";
    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public void printLottos(final Lottos lottos) {
        printAmount(lottos);
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto.getLottoNumbers());
        }
    }

    private void printAmount(final Lottos lottos) {
        System.out.println(lottos.getLottos().size() + LOTTO_AMOUNT_MESSAGE);
    }

    private void printLotto(final List<LottoNumber> lottoNumbers) {
        final List<Integer> numbers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        System.out.println(numbers);
    }

    public void finishGame(final Map<Ranking, Integer> totalResult, final double totalWinnerPrize) {
        System.out.println(LOTTO_STATISTICS_MESSAGE);
        System.out.println(HYPHEN_MESSAGE);

        final List<Ranking> rankings = new LinkedList<>(totalResult.keySet());
        Collections.sort(rankings);
        Collections.reverse(rankings);

        rankings.forEach(ranking -> printLottoResult(ranking, totalResult.get(ranking)));
        printYield(totalWinnerPrize);
    }

    private void printYield(final double totalWinnerPrice) {
        System.out.printf(
            TOTAL_YIELD_MESSAGE + String.format("%.2f", totalWinnerPrice) + FINISH_MESSAGE);
    }

    private void printLottoResult(final Ranking ranking, final Integer count) {
        final StringBuilder stringBuilder = new StringBuilder();

        if (ranking.isFail()) {
            return;
        }

        stringBuilder.append(OPENING_PARENTHESIS)
            .append(ranking.getWinnerPrice())
            .append(WON_MESSAGE)
            .append(count)
            .append(AMOUNT_MESSAGE);

        if (ranking.equals(Ranking.SECOND)) {
            stringBuilder.insert(0,
                ranking.getNormalNumberMatchCount() + MATCH_AMOUNT_MESSAGE + COMMA + SPACE
                    + BONUS_BALL_MATCH_MESSAGE);
            System.out.println(stringBuilder);
            return;
        }

        stringBuilder.insert(0, ranking.getNormalNumberMatchCount()
            + MATCH_AMOUNT_MESSAGE + SPACE);
        System.out.println(stringBuilder);
    }
}
