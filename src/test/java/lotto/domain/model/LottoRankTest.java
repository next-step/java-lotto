package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankTest {
    @Test
    @DisplayName("로또 번호의 갯수보다 더 많은 수의 당첨이 되면 예외가 발생한다.")
    void invalidMatchedNumberTest() {
        assertThatThrownBy(() -> LottoRank.of(7, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 번호가 일치한 갯수에 따라 올바른 rank를 반환한다.")
    @MethodSource("rankTestCases")
    void rankReturnTest(int numOfMatched, boolean bonusMatched, LottoRank expected) {
        LottoRank actual = LottoRank.of(numOfMatched, bonusMatched);
        assertEquals(actual, expected);
    }

    static Stream<Arguments> rankTestCases() {
        return Stream.of(
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(6, true, LottoRank.FIRST)
        );
    }
}
