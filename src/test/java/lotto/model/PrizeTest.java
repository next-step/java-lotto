package lotto.model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    private Prize create(List<Rank> ranks) {
        EnumMap<Rank, Integer> rankEnumMap = ranks.stream()
                .collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum, () -> new EnumMap<>(Rank.class)));
        return new Prize(rankEnumMap);
    }

    @Test
    void 생성() {
        Prize prize = create(List.of(Rank.FOUR));
        assertThat(prize).isEqualTo(new Prize(new EnumMap<>(Map.of(Rank.FOUR, 1))));
    }

    @Test
    void 당첨순위별_개수를_확인한다() {
        Prize prize = create(List.of(Rank.FOUR, Rank.FOUR, Rank.FOUR, Rank.TWO));

        assertThat(prize.rankCount(Rank.FOUR)).isEqualTo(3);
        assertThat(prize.rankCount(Rank.TWO)).isEqualTo(1);
        assertThat(prize.rankCount(Rank.ONE)).isEqualTo(0);
    }

    private enum ExpectedRateOfReturn {
        ONE(142857.14),
        TWO(2142.85),
        THREE(107.14),
        FOUR(3.57),
        FIVE(0.35),
        NO_MATCH(0.0);

        double value;

        ExpectedRateOfReturn(double value) {
            this.value = value;
        }
    }

    @ParameterizedTest
    @EnumSource
    void 당첨순위별_수익률(Rank rank) {
        String rankName = rank.name();
        ExpectedRateOfReturn expectedRateOfReturn = ExpectedRateOfReturn.valueOf(rankName);

        Prize prize = create(List.of(rank));
        int quantity = 14;

        assertThat(prize.rateOfReturn(quantity))
                .isEqualTo(expectedRateOfReturn.value, Offset.offset(0.1));
    }
}
