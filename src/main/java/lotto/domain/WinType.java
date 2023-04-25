package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinType {
    FIRST(new MatchedQuantity(6, 0), 2_000_000_000),
    SECOND(new MatchedQuantity(5, 1), 30_000_000),
    THIRD(new MatchedQuantity(5, 0), 1_500_000),
    FOURTH(new MatchedQuantity(4, 0), 50_000),
    FIFTH(new MatchedQuantity(3, 0), 5_000),
    FAIL(new MatchedQuantity(0, 0), 0);

    private final MatchedQuantity matchedQuantity;
    private final long winnings;

    private static final Map<MatchedQuantity, WinType> WIN_TYPE_MAP
            = Collections.unmodifiableMap(Stream.of(values())
                                                .collect(Collectors.toMap(WinType::getMatchedQuantity, x -> x)));

    WinType(MatchedQuantity matchedQuantity, long winnings) {
        this.matchedQuantity = matchedQuantity;
        this.winnings = winnings;
    }

    public MatchedQuantity getMatchedQuantity() {
        return matchedQuantity;
    }

    public long getWinnings() {
        return winnings;
    }

    public static WinType find(long matchedQuantity, long matchBonus) {
        if (WIN_TYPE_MAP.containsKey(new MatchedQuantity(matchedQuantity, matchBonus))) {
            return WIN_TYPE_MAP.get(new MatchedQuantity(matchedQuantity, matchBonus));
        }

        return FAIL;
    }

    private static class MatchedQuantity {
        private final long numberMatchedQuantity;
        private final long bonusNumberMatchedQuantity;

        public MatchedQuantity(long numberMatchedQuantity, long bonusNumberMatchedQuantity) {
            this.numberMatchedQuantity = numberMatchedQuantity;
            this.bonusNumberMatchedQuantity = bonusNumberMatchedQuantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MatchedQuantity that = (MatchedQuantity) o;
            return numberMatchedQuantity == that.numberMatchedQuantity && bonusNumberMatchedQuantity == that.bonusNumberMatchedQuantity;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numberMatchedQuantity, bonusNumberMatchedQuantity);
        }
    }
}
