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
    @MethodSource("testNumbers")
    void find_prize_test(int matchingCount, Prize prize) {
        assertThat(Prize.findPrize(matchingCount)).isEqualTo(prize);
    }

    @DisplayName("bonusNumber가 포함된 Prize 찾기 테스트")
    @ParameterizedTest
    @MethodSource("testNumbersWithBonus")
    void find_prize_with_bonus_test(int matchingCount, boolean containBonus, Prize prize) {
        assertThat(Prize.findPrize(matchingCount, containBonus)).isEqualTo(prize);
    }

    static Stream<Arguments> testNumbers() {
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

    static Stream<Arguments> testNumbersWithBonus() {
        return Stream.of(
                arguments(6, true, Prize.RANK_1TH),
                arguments(5, true, Prize.RANK_2TH),
                arguments(4, true, Prize.RANK_2TH_WITH_BONUS),
                arguments(4, false, Prize.RANK_3TH)
        );
    }

}
