package lotto.domain;

import lotto.enums.LottoPrize;
import java.util.List;

public class LottoStatistics {

    private static final double PRICE_OF_LOTTO = 1000;

    private static final int NUMBER_OF_WINNING_LEVELS = 4;

    private static final int MIN_MATCHES = 3;

    private static final int MAX_MATCHES = 6;

    private final WinnerLotto winnerLotto;

    private final List<Lotto> lottos;

    private final int[] matchCounts;

    public LottoStatistics(WinnerLotto winnerLotto, List<Lotto> lottos) {
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
            int countOfMatch = lotto.countMatch(winnerLotto.getLottoNumbers());

            if (countOfMatch < MIN_MATCHES || countOfMatch > MAX_MATCHES) {
                continue;
            }

            matchCounts[countOfMatch - MIN_MATCHES]++;
        }
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

    /**
     * 당첨 통계를 출력
     */
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n------\n");

        appendMatchCounts(sb);

        double yield = calculateYield();
        sb.append(String.format("총 수익률은 %.2f%s 입니다. ", yield, (yield > 1 ? "" : " (기준이 1이기 때문에 결과적으로 손해라는 의미임)")));
        return sb.toString();
    }

    /**
     * 각 당첨 수준에 대한 수를 출력
     */
    private void appendMatchCounts(StringBuilder sb) {
        for (int i = 0; i < NUMBER_OF_WINNING_LEVELS; i++) {
            int matches = i + 3;
            LottoPrize prize = LottoPrize.valueOf(matches);
            sb.append(String.format("%d 개 일치 (%s) 원 - %d 개\n", matches, prize.getPrizeMoneyFormat(), matchCounts[i]));
        }
    }
}
