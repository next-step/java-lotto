package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private final Map<Rank, Integer> map = new HashMap<>();
    private Result result;

    @BeforeEach
    void setUp() {
        map.put(Rank.FIFTH, 1);
        map.put(Rank.FOURTH, 1);
        map.put(Rank.THIRD, 2);
        map.put(Rank.FIRST, 1);
        result = new Result(map);
    }

    @Test
    @DisplayName("getNumOfLotto 확인")
    void getNumOfLotto() {
        Assertions.assertAll(
                () -> assertThat(result.getNumOfLotto(Rank.FIFTH))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Rank.FOURTH))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Rank.THIRD))
                        .isEqualTo(2),
                () -> assertThat(result.getNumOfLotto(Rank.FIRST))
                        .isEqualTo(1)
        );
    }

    @Test
    @DisplayName("profit 과 rateOfReturn 을 정상적으로 계산해야한다.")
    void getProfit() {
        int expectedProfit = 2003055000;
        double expectedRateOfReturn = 2806.0;
        Assertions.assertAll(
                () -> assertThat(result.getProfit())
                        .isEqualTo(new Money(expectedProfit)),
                () -> assertThat(result.getRateOfReturn(new Money(713793)))
                        .isEqualTo(expectedRateOfReturn)
        );
    }
}
