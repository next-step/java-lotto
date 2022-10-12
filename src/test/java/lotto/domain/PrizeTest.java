package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

    @DisplayName("Prize 찾기 테스트")
    @ParameterizedTest
    @MethodSource("exceptionNumberCase")
    void find_prize_test(int matchingCount, Prize prize) {
        assertThat(Prize.findPrize(matchingCount)).isEqualTo(prize);
    }

    static Stream<Arguments> exceptionNumberCase() {
        return Stream.of(
                arguments(6, Prize.RANK_1TH),
                arguments(5, Prize.RANK_2TH),
                arguments(4, Prize.RANK_3TH),
                arguments(3, Prize.RANK_4TH),
                arguments(2, Prize.NO_RANK),
                arguments(1, Prize.NO_RANK),
                arguments(0, Prize.NO_RANK)
        );
    }

}
