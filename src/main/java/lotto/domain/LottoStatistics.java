package lotto.domain;

import lotto.enums.LottoPrize;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatistics {

    private static final double PRICE_OF_LOTTO = 1000;

    private static final int MIN_MATCHES = 3;

    private static final int MAX_MATCHES = 6;

    private final Lotto winnerLotto;

    private final List<Lotto> lottoList;

    private final Map<LottoPrize, Integer> matchCounts;

    public LottoStatistics(Lotto winnerLotto, List<Lotto> lottoList) {
        this.winnerLotto = winnerLotto;
        this.lottoList = lottoList;
        this.matchCounts = new EnumMap<>(LottoPrize.class);
        updateMatchCounts();
    }

    /**
     * Lotto 객체에서 일치하는 숫자의 수를 세고,
     * matchCounts 배열에 가능한 각 당첨 수준에 대한 수를 저장
     */
    private void updateMatchCounts() {
        lottoList.forEach(this::editMatchCount);
    }

    private void editMatchCount(final Lotto lotto) {
        int countOfMatch = lotto.countMatch(winnerLotto.getLottoNumbers());

        if (countOfMatch < MIN_MATCHES || countOfMatch > MAX_MATCHES) {
            return;
        }

        LottoPrize prize = LottoPrize.valueOf(countOfMatch);
        matchCounts.compute(prize, (key, value) -> value == null ? 1 : value + 1);
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
        return lottoList.size() * PRICE_OF_LOTTO;
    }

    public List<Integer> getMatchCounts() {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize != LottoPrize.NONE)
                .map(prize -> matchCounts.getOrDefault(prize, 0))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
