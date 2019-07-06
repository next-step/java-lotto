package lotto.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositiveNumberTest {

    @Test
    @DisplayName("양의 정수값을 정상적으로 가져오는지 확인한다")
    void getPositiveNumber() {
        PositiveNumber positiveNumber = PositiveNumber.of(7L);
        assertThat(positiveNumber.get()).isEqualTo(7L);
    }

    @Test
    @DisplayName("음수인경우 예외를 발생시키는지 확인한다")
    void checkException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PositiveNumber.of(-7L);
                }).withMessageMatching("Invalid number range");
    }
}
