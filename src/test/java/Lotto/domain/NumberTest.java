package Lotto.domain;

import Lotto.exception.OverflowNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46,100,500,999})
    @DisplayName("로또 숫자가 45가 넘으면 예외를 던진다.")
    public void validateTest(int lottoNumber) {
        Assertions.assertThatExceptionOfType(OverflowNumberException.class).isThrownBy(
                () -> new Number(lottoNumber)
        );
    }
}
