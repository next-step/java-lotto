package lotto.model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void 전부_꽝일_경우_수익률() {
        int quantity = 14;
        Map<Integer, Integer> resultMap = Map.of();

        assertThat(Rank.rateOfReturn(resultMap, quantity))
                .isEqualTo(0.0);
    }


    @Test
    void 오천원_한개_당첨될경우_수익률() {
        int quantity = 14;
        Map<Integer, Integer> resultMap = Map.of(3, 1);

        assertThat(Rank.rateOfReturn(resultMap, quantity))
                .isEqualTo(0.35, Offset.offset(0.1));
    }

    @Test
    void 오만원_한개_당첨될경우_수익률() {
        int quantity = 14;
        Map<Integer, Integer> resultMap = Map.of(4, 1);

        assertThat(Rank.rateOfReturn(resultMap, quantity))
                .isEqualTo(3.57, Offset.offset(0.1));
    }

    @Test
    void 이등_당첨될경우_수익률() {
        int quantity = 14;
        Map<Integer, Integer> resultMap = Map.of(5, 1);

        assertThat(Rank.rateOfReturn(resultMap, quantity))
                .isEqualTo(107.14, Offset.offset(0.1));
    }

    @Test
    void 일등_당첨될경우_수익률() {
        int quantity = 14;
        Map<Integer, Integer> resultMap = Map.of(6, 1);

        assertThat(Rank.rateOfReturn(resultMap, quantity))
                .isEqualTo(142857.14, Offset.offset(0.1));
    }
}
