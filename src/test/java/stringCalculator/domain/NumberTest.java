package stringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {

    @Test
    void create() {
        Number number = new Number("2");

        assertThat(number.getNumber()).isEqualTo(2);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 null 또는 빈문자이면 예외가 발생한다.")
    void throwExceptionForNullNameOrEmpty(String invalidNumber) {
        assertThatThrownBy(() -> {
            new Number(invalidNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
