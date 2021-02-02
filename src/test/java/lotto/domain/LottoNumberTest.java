package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumberTest {

    @DisplayName("1-45 범위의 수인 lottoNumber일 경우 객체가 생성됨")
    @ParameterizedTest
    @MethodSource("provideCheckLottoNumberGoodTest")
    void checkLottoNumberGoodTest(int num) {
        LottoNumber lottoNumber = new LottoNumber(num);
        assertEquals(lottoNumber, lottoNumber.getLottoNumber());
    }

    private static Stream<Arguments> provideCheckLottoNumberGoodTest() {
        return Stream.of(
            Arguments.of(45),
            Arguments.of(1)
        );
    }

    @DisplayName("범위에서 벗어난 lottoNumber일 경우 예외가 남")
    @ParameterizedTest
    @MethodSource("provideCheckLottoNumberBadTest")
    void checkLottoNumberBadTest(int num) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(num));
    }

    private static Stream<Arguments> provideCheckLottoNumberBadTest() {
        return Stream.of(
            Arguments.of(99),
            Arguments.of(0)
        );
    }
}
