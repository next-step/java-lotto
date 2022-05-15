package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prize {
    private final Lotto beforeLotto;
    private final Number bonusNumber;
    private final List<Rank> ranks;

    private Prize(Lotto beforeLotto) {
        this(beforeLotto, Number.of());
    }

    private Prize(Lotto beforeLotto, Number bonusNumber) {
        this.beforeLotto = beforeLotto;
        this.bonusNumber = bonusNumber;
        this.ranks = new ArrayList<>();
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
            this.ranks.add(rank);
        });

        return this;
    }

    private Number getTotalPrize() {
        long prize = Arrays.stream(Rank.values())
                .mapToLong(rank -> rank.getTotalPrizeMoney(this.ranks).longValue())
                .sum();

        return Number.of(prize);
    }

    private Number getPrice() {
        Number left = Number.of(this.ranks.size());
        Number right = Number.of(1000L);

        return left.multiply(right);
    }

    public List<Rank> getRanks() {
        return this.ranks;
    }

    public double getWinningRate() {
        return this.getTotalPrize()
                .divide(this.getPrice())
                .doubleValue();
    }
}
