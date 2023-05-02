package lotto.domain;

import lotto.enums.LottoPrize;
import java.util.List;

public class LottoStatistics {

    private static final double PRICE_OF_LOTTO = 1000;

    private static final int NUMBER_OF_WINNING_LEVELS = 4;

    private static final int MIN_MATCHES = 3;

    private static final int MAX_MATCHES = 6;

    private final Lotto winnerLotto;

    private final List<Lotto> lottos;

    private final int[] matchCounts;

    public LottoStatistics(Lotto winnerLotto, List<Lotto> lottos) {
        this.winnerLotto = winnerLotto;
        this.lottos = lottos;
        this.matchCounts = new int[NUMBER_OF_WINNING_LEVELS];
        updateMatchCounts();
    }

    /**
     * Lotto 객체에서 일치하는 숫자의 수를 세고,
     * matchCounts 배열에 가능한 각 당첨 수준에 대한 수를 저장
     */
    private void updateMatchCounts() {
        for (Lotto lotto : lottos) {
            editMatchCount(lotto);
        }
    }

    private void editMatchCount(final Lotto lotto) {
        int countOfMatch = lotto.countMatch(winnerLotto.getLottoNumbers());

        if (countOfMatch < MIN_MATCHES || countOfMatch > MAX_MATCHES) {
            return;
        }

        matchCounts[countOfMatch - MIN_MATCHES]++;
    }

    /**
     * 수익률 = (총 수익액 - 총 구입 금액) / 총 구입 금액
     * @return 수익률
     */
    public double calculateYield() {
        double revenue = calculateRevenue();
        return (revenue - calculateCost()) / calculateCost();
    }

    /**
     * 모든 로또 티켓에 의해 생성된 총 수익을 계산
     */
    private double calculateRevenue() {
        double revenue = 0;
        for (int i = 0; i < NUMBER_OF_WINNING_LEVELS; i++) {
            int matches = i + MIN_MATCHES;
            LottoPrize prize = LottoPrize.valueOf(matches);
            revenue += prize.getPrizeMoney() * matchCounts[i];
        }
        return revenue;
    }

    /**
     * 모든 로또 티켓을 구매하는 총 비용을 계산
     */
    private double calculateCost() {
        return lottos.size() * PRICE_OF_LOTTO;
    }

    public int[] getMatchCounts() {
        return matchCounts;
    }

}
