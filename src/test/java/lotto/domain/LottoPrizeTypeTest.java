package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPrizeTypeTest {

    @Test
    void match_one_prize() {
        Assertions.assertThat(LottoPrizeType.of(6, false)).isEqualTo(LottoPrizeType.ONE_PRIZE);
    }

    @Test
    void match_two_prize() {
        Assertions.assertThat(LottoPrizeType.of(5, true)).isEqualTo(LottoPrizeType.TWO_PRIZE);
    }

    @Test
    void match_three_prize() {
        Assertions.assertThat(LottoPrizeType.of(5, false)).isEqualTo(LottoPrizeType.THREE_PRIZE);
    }


    @Test
    void match_four_prize() {
        Assertions.assertThat(LottoPrizeType.of(4, false)).isEqualTo(LottoPrizeType.FOUR_PRIZE);
    }

    @Test
    void match_five_prize() {
        Assertions.assertThat(LottoPrizeType.of(3, false)).isEqualTo(LottoPrizeType.FIVE_PRIZE);
    }


    @ParameterizedTest
    @ValueSource(strings = {"2", "1", "0"})
    void match_none_prize(int matchCount) {
        Assertions.assertThat(LottoPrizeType.of(matchCount, false)).isEqualTo(LottoPrizeType.NONE);
    }


}
