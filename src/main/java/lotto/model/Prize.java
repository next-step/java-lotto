package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Prize {
    private final Lotto beforeLotto;
    private final Number bonusNumber;
    private final Map<Rank, Number> ranks;

    private Prize(Lotto beforeLotto) {
        this(beforeLotto, Number.of());
    }

    private Prize(Lotto beforeLotto, Number bonusNumber) {
        this.beforeLotto = beforeLotto;
        this.bonusNumber = bonusNumber;
        this.ranks = new EnumMap<>(Rank.class);
        Stream.of(Rank.values()).forEach(this::computeIfAbsent);
    }

    public static Prize init(Lotto beforeLotto) {
        return new Prize(beforeLotto);
    }

    public static Prize init(Lotto beforeLotto, Number bonusNumber) {
        return new Prize(beforeLotto, bonusNumber);
    }

    public Prize classify(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> {
            Rank rank = Lotto
                    .getRank(this.beforeLotto, lotto)
                    .checkBonus(this.bonusNumber, lotto);
            this.computeIfPresent(rank);
        });

        return this;
    }

    public void computeIfPresent(Rank rank) {
        this.ranks.computeIfPresent(rank, (r, count) -> count.incrementAndGet());
    }

    public void computeIfAbsent(Rank rank) {
        this.ranks.computeIfAbsent(rank, r -> Number.of());
    }

    private Number getTotalPrize() {
        long prize = this.ranks
                .entrySet()
                .stream()
                .map(rank -> rank.getValue().multiple(rank.getKey().getPrizeMoney()))
                .mapToLong(Number::longValue)
                .sum();

        return Number.of(prize);
    }

    private Number getPrice() {
        long price = this.ranks
                .values()
                .stream()
                .mapToLong(Number::longValue)
                .sum() * 1000;

        return Number.of(price);
    }

    public Map<Rank, Number> getRanks() {
        return this.ranks;
    }

    public double getWinningRate() {
        return this.getTotalPrize()
                .divide(this.getPrice())
                .doubleValue();
    }
}
