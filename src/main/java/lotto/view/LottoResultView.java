package lotto.view;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
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

    private int totalWinnerPrice = ZERO;

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

    public void finishGame(final Map<Ranking, Integer> totalResult, final Money money) {
        System.out.println(LOTTO_STATISTICS_MESSAGE);
        System.out.println(HYPHEN_MESSAGE);

        final List<Ranking> rankings = new LinkedList<>(totalResult.keySet());
        Collections.sort(rankings);
        Collections.reverse(rankings);

        rankings.forEach(key ->
            process(key, totalResult.get(key)));

        printYield(money);
    }

    private void printYield(final Money money) {
        System.out.printf(
            TOTAL_YIELD_MESSAGE + String.format("%.2f",
                (double) totalWinnerPrice / money.getMoney())
                + FINISH_MESSAGE);
    }

    private void process(final Ranking ranking, final Integer count) {
        if (ranking.isFail()) {
            return;
        }

        if (ranking.equals(Ranking.SECOND)) {
            System.out.println(
                ranking.getNormalNumberMatchCount() + MATCH_AMOUNT_MESSAGE + COMMA + SPACE
                    + BONUS_BALL_MATCH_MESSAGE
                    + OPENING_PARENTHESIS
                    + ranking.getWinnerPrice() + WON_MESSAGE
                    + count + AMOUNT_MESSAGE);
        }

        System.out.println(
            ranking.getNormalNumberMatchCount() + MATCH_AMOUNT_MESSAGE + SPACE + OPENING_PARENTHESIS
                + ranking.getWinnerPrice() + WON_MESSAGE
                + count + AMOUNT_MESSAGE);

        totalWinnerPrice += ranking.multiplyCountAndWinnerPrice(count);
    }

}
