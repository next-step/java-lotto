package lotto.domain;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private final int autoLottoCount;

    public Lottos(int money) {
        this(money, new ArrayList<>());
    }

    public Lottos(List<Lotto> manualLottos) {
        this(LOTTO_PRICE * manualLottos.size(), manualLottos);
    }

    public Lottos(int money, List<Lotto> manualLottos) {
        if (isInvalidMoney(money)) {
            throw new IllegalArgumentException("구입 금액은 1000의 배수인 양수여야 합니다.");
        }

        int autoLottoCount = money / LOTTO_PRICE - manualLottos.size();
        this.autoLottoCount = autoLottoCount;

        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    private boolean isInvalidMoney(int money) {
        return money <= 0 || money % LOTTO_PRICE != 0;
    }

    public Map<Rank, Long> getRankCount(WinNumbers winNumbers) {
        return EnumSet.allOf(Rank.class)
                .stream()
                .collect(rankCountMapCollector(winNumbers));
    }

    private Collector<Rank, ?, Map<Rank, Long>> rankCountMapCollector(WinNumbers winNumbers) {
        return Collectors.toMap(
                rank -> rank,
                rank -> lottos.stream()
                        .filter(lotto -> Rank.of(lotto, winNumbers).equals(rank))
                        .count()
        );
    }

    public int getManualLottoCount() {
        return this.lottos.size() - this.autoLottoCount;
    }

    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }

    public double getEarningRate(WinNumbers winNumbers) {
        return getTotalPrize(winNumbers) / getTotalPrice();
    }

    private double getTotalPrize(WinNumbers winNumbers) {
        return lottos.stream()
                .map(lotto -> Rank.of(lotto, winNumbers))
                .map(Rank::getPrize)
                .reduce(0L, Long::sum);
    }

    private double getTotalPrice() {
        return this.lottos.size() * LOTTO_PRICE;
    }

    public List<Set<LottoNumber>> getNumbers() {
        return this.lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public Boolean isGain(WinNumbers winNumbers) {
        return getEarningRate(winNumbers) > 1;
    }

    public Boolean isLoss(WinNumbers winNumbers) {
        return getEarningRate(winNumbers) < 1;
    }
}
