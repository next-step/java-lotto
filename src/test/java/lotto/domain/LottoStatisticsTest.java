package lotto.domain;

import lotto.util.DivisionNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    @DisplayName("yield Test")
    @Test
    void yield() {
        Map<LottoRank, Integer> data = new HashMap<>();
        data.put(LottoRank.FIRST_PLACE, 1);
        data.put(LottoRank.SECOND_PLACE, 1);
        data.put(LottoRank.THREE_PLACE, 1);
        data.put(LottoRank.FOUR_PLACE, 1);

        DivisionNumber expertMoney = new DivisionNumber(2000000000 + 1500000 +50000 + 5000, Lotto.PRICE.multiply(4));
        System.out.println(expertMoney.intValue());

        LottoStatistics lottoStatistics = new LottoStatistics(data);
        assertThat(lottoStatistics.yield())
                .withFailMessage(String.valueOf(lottoStatistics.yield().intValue()))
                .isEqualTo(
                        expertMoney
                );
    }

    @DisplayName("count Test")
    @Test
    void count() {
        Map<LottoRank, Integer> data = new HashMap<>();
        data.put(LottoRank.THREE_PLACE, 5);
        data.put(LottoRank.FOUR_PLACE, 10);

        LottoStatistics lottoStatistics = new LottoStatistics(data);
        assertThat(lottoStatistics.size(LottoRank.THREE_PLACE))
                .isEqualTo(5);
        assertThat(lottoStatistics.size(LottoRank.FOUR_PLACE))
                .isEqualTo(10);
    }
}