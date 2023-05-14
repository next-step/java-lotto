package lotto.domain;

import lotto.enums.LottoPrize;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private static final double PRICE_OF_LOTTO = 1000;

    private final WinnerLotto winnerLotto;

    private final Lottos lottoList;

    private final Map<LottoPrize, Integer> matchCounts;

    public LottoStatistics(WinnerLotto winnerLotto, Lottos lottoList) {
        this.winnerLotto = winnerLotto;
        this.lottoList = lottoList;
        this.matchCounts = new EnumMap<>(LottoPrize.class);
        updateMatchCounts();
    }

    /**
     * Lotto 객체에서 일치하는 숫자의 수를 세고,
     * matchCounts 배열에 가능한 각 당첨 수준에 대한 수를 저장
     */
    public void updateMatchCounts() {
        matchCounts.clear();
        matchCounts.putAll(lottoList.getMatchCounts(winnerLotto));
    }

    /**
     * 모든 로또 티켓에 의해 생성된 총 수익을 계산
     */
    public double calculateYield() {
        double revenue = calculateRevenue();
        double cost = calculateCost();
        return (revenue - cost) / cost;
    }

    private double calculateRevenue() {
        return matchCounts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
    /**
     * 모든 로또 티켓을 구매하는 총 비용을 계산
     */
    private double calculateCost() {
        final int ticketCount = lottoList
                .getLottoList()
                .size();

        return ticketCount * PRICE_OF_LOTTO;
    }

    public Map<LottoPrize, Integer> getMatchCountsMap() {
        return matchCounts;
    }

}
