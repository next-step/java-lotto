package lotto.model;

import java.util.Arrays;
import java.util.Set;

public enum Rank {
    CHECKBONUS(Integer.MAX_VALUE, 0),
    MISS(0, 0),
    FIVE(3, 5_000),
    FOUR(4, 50_000),
    THREE(5, 1_500_000),
    TWO(5, 30_000_000),
    ONE(6, 2_000_000_000);

    private final int order;
    private final int price;

    Rank(int order, int price) {
        this.order = order;
        this.price = price;
    }

    public int calculatePrice(int value) {
        return this.price * value;
    }

    public static Rank findRank(int count) {
        Rank rank = Arrays.stream(Rank.values())
                .filter(value -> count == value.order)
                .findFirst()
                .orElse(MISS);

        if (rank.order == TWO.order) {
            return CHECKBONUS;
        }

        return rank;
    }

    public Rank checkBonus(WinningLotto winningLotto, Set<LottoNumber> lotto) {
        if (this == CHECKBONUS) {
            return checkBonusRank(winningLotto, lotto);
        }
        return this;
    }

    private Rank checkBonusRank(WinningLotto winningLotto, Set<LottoNumber> lotto) {
        if (isBonus(winningLotto, lotto)) {
            return TWO;
        }
        return THREE;
    }

    private boolean isBonus(WinningLotto winningLotto, Set<LottoNumber> lotto) {
        return lotto.stream()
                .anyMatch(winningLotto::isMatchBonus);
    }

    public int getPrice() {
        return price;
    }
}
