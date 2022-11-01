package lotto.domain;

import java.util.*;

public class Lottos {

    public final List<Lotto> lottos;

    public Lottos(final Lottos lottos) {
        this(lottos.lottos);
    }

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public static Lottos union(final Lottos first, final Lottos second) {
        if (Objects.isNull(first)) {
            return new Lottos(second);
        }

        if (Objects.isNull(second)) {
            return new Lottos(first);
        }

        return new Lottos(new ArrayList<>() {{
            addAll(first.lottos);
            addAll(second.lottos);
        }});
    }

    public LottoWinningStatistics giveOutWinningStatistics(final int lottoPurchaseAmount,
                                                           final WinningLottoNumbers winningLottoNumbers) {
        Map<LottoWinningType, Integer> lottoWinningTypeCountMap = countLottoWinningTypes(winningLottoNumbers);
        double yield = calculateYield(lottoPurchaseAmount, lottoWinningTypeCountMap);

        return new LottoWinningStatistics(lottoWinningTypeCountMap, yield);
    }

    private Map<LottoWinningType, Integer> countLottoWinningTypes(final WinningLottoNumbers winningLottoNumbers) {
        Map<LottoWinningType, Integer> countMap = new EnumMap<>(LottoWinningType.class);

        this.lottos.forEach(lotto -> {
            LottoWinningType lottoWinningType = LottoWinningType.valueOf(winningLottoNumbers.countOfMatch(lotto),
                    winningLottoNumbers.matchBonus(lotto));
            countMap.put(lottoWinningType, countMap.getOrDefault(lottoWinningType, 0) + 1);
        });

        return countMap;
    }

    private double calculateYield(final int lottoPurchaseAmount,
                                  final Map<LottoWinningType, Integer> lottoWinningTypeCountMap) {
        int winningAmountSum = 0;
        for (LottoWinningType lottoWinningType : LottoWinningType.values()) {
            int lottoWinningTypeCount = lottoWinningTypeCountMap.getOrDefault(lottoWinningType, 0);
            winningAmountSum += lottoWinningTypeCount * lottoWinningType.getWinningAmount();
        }
        return floor((double) winningAmountSum / lottoPurchaseAmount, 2);
    }

    private double floor(final double number, final int decimal) {
        return Math.floor(number * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }
}
