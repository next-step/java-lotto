package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LotteryNumberTest {
    private static Stream<Arguments> provideLotteryNumberForTest() {
        return Stream.of(
                Arguments.of(LottoNumber.asList(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(1)),
                Arguments.of(LottoNumber.asList(Arrays.asList(1, 2, 3, 4, 5)), new LottoNumber(45)),
                Arguments.of(LottoNumber.asList(Arrays.asList(1, 2, 3, 4, 5, 5)), new LottoNumber(45))
        );
    }

    @DisplayName("LotteryNumber 이상한 값 validate 테스트")
    @ParameterizedTest
    @MethodSource("provideLotteryNumberForTest")
    public void lotteryNumberValidateTest(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryNumber(winningNumbers, bonusNumber));
    }
}