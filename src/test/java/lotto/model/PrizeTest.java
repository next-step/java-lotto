package lotto.model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

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

    @Test
    void 꽝일_경우_수익률() {
        int quantity = 14;
        Prize prize = create(List.of(Rank.NO_MATCH));

        assertThat(prize.rateOfReturn(quantity))
                .isEqualTo(0.0);
    }

    @Test
    void 오천원_한개_당첨될경우_수익률() {
        int quantity = 14;
        Prize prize = create(List.of(Rank.FIVE));

        double rateOfReturn = prize.rateOfReturn(quantity);
        assertThat(rateOfReturn).isEqualTo(0.35, Offset.offset(0.1));
    }

    @Test
    void 오만원_한개_당첨될경우_수익률() {
        int quantity = 14;
        Prize prize = create(List.of(Rank.FOUR));

        double rateOfReturn = prize.rateOfReturn(quantity);
        assertThat(rateOfReturn).isEqualTo(3.57, Offset.offset(0.1));
    }

    @Test
    void 이등_당첨될경우_수익률() {
        int quantity = 14;
        Prize prize = create(List.of(Rank.TWO));

        double rateOfReturn = prize.rateOfReturn(quantity);
        assertThat(rateOfReturn).isEqualTo(2142.85, Offset.offset(0.1));
    }

    @Test
    void 일등_당첨될경우_수익률() {
        int quantity = 14;
        Prize prize = create(List.of(Rank.ONE));

        double rateOfReturn = prize.rateOfReturn(quantity);
        assertThat(rateOfReturn).isEqualTo(142857.14, Offset.offset(0.1));
    }
}
