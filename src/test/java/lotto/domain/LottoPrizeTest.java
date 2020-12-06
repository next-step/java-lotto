package lotto.domain;

import lotto.domain.exceptions.NotExistLottoPrizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPrizeTest {
    @DisplayName("맞춘 LottoNumber 수에 맞는 LottoPrize를 받을 수 있다.")
    @ParameterizedTest
    @MethodSource("findTestResource")
    void findTest(int numberOfMatchedNumber, LottoPrize expected) {
        assertThat(LottoPrize.find(numberOfMatchedNumber)).isEqualTo(expected);
    }
    public static Stream<Arguments> findTestResource() {
        return Stream.of(
                Arguments.of(6, LottoPrize.FIRST),
                Arguments.of(5, LottoPrize.SECOND),
                Arguments.of(4, LottoPrize.THIRD),
                Arguments.of(3, LottoPrize.FOURTH)
        );
    }

    @DisplayName("존재하지 않는 당첨 결과를 찾으려는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 7})
    void findFailTest(int invalidValue) {
        assertThatThrownBy(() -> LottoPrize.find(invalidValue)).isInstanceOf(NotExistLottoPrizeException.class);
    }
}
