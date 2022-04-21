package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PrizeTest {

    @ParameterizedTest(name = "일치하는 숫자 개수로 Prize를 조회한다." +
            " 5개가 일치하고 추가 번호가 있으면 BONUS.")
    @MethodSource("provideArgumentsForFindPrizeByMatchCount")
    void findPrizeByMatchCount(int matchCount, boolean containsBonus, Prize prize) {
        assertThat(Prize.findPrizeByMatchCount(matchCount, containsBonus))
                .isEqualTo(prize);
    }

    private static Stream<Arguments> provideArgumentsForFindPrizeByMatchCount() {
        return Stream.of(
                Arguments.of(0, false, Prize.ZERO),
                Arguments.of(4, false, Prize.FOUR),
                Arguments.of(4, true, Prize.FOUR),
                Arguments.of(5, false, Prize.FIVE),
                Arguments.of(5, true, Prize.BONUS),
                Arguments.of(6, false, Prize.SIX)
        );
    }

    @ParameterizedTest(name = "0에서 6까지의 숫자로만 상긍을 조회할 수 있다.")
    @ValueSource(ints = {-1, 7})
    void findPrizeByMatchCount_Exception(int invalidMatchCount) {
        assertThatThrownBy(() -> Prize.findPrizeByMatchCount(invalidMatchCount, false))
                .isInstanceOf(NoSuchElementException.class);
    }
}