package lotto.domain;

import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(4, 1_500_000),
    FOURTH(3, 50_000),
    FIFTH(2, 5_000),
    NOT_MATCH(0, 0);

    private int match;
    private int price;

    Rank(final int match, final int price) {
        this.match = match;
        this.price = price;
    }

    public static Integer countMatchLottos(Rank rank, List<Lotto> lottos, Lotto winningLotto) {
        return (int) lottos.stream()
                        .filter(lotto -> rank.match == lotto.match(winningLotto))
                        .count();
    }

    public int getPrice() {
        return this.price;
    }
}
