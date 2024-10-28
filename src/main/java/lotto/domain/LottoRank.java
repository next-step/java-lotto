package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank implements Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000,BonusMatcher.FALSE),
    SECOND(5, 30_000_000, BonusMatcher.TRUE),
    FIRST(6, 2_000_000_000);

    private final int count;
    private final int price;
    private final BonusMatcher matchBonus;


    LottoRank(int count, int price, BonusMatcher matchBonus) {
        this.count = count;
        this.price = price;
        this.matchBonus = matchBonus;
    }

    LottoRank(int count, int price) {
        this(count, price, BonusMatcher.NONE);
    }

    public static Rank match(final int count, final boolean matchBonus) {
        Optional<LottoRank> rank = Arrays.stream(values()).filter(v -> v.count == count)
                .filter(v -> v.matchBonus.match(matchBonus)).findFirst();
        if (rank.isPresent()) {
            return rank.get();
        }
        return None.NONE;
    }

    @Override
    public int price() {
        return this.price;
    }

    public int count() {
        return this.count;
    }

    public enum None implements Rank {
        NONE;

        @Override
        public int price() {
            return 0;
        }
    }

    private enum BonusMatcher {
        NONE {
            @Override
            public boolean match(boolean matchBonus) {
                return true;
            }
        },
        FALSE {
            @Override
            public boolean match(boolean matchBonus) {
                return !matchBonus;
            }
        },
        TRUE {
            @Override
            public boolean match(boolean matchBonus) {
                return matchBonus;
            }
        };

        protected abstract boolean match(boolean matchBonus);
    }
}
