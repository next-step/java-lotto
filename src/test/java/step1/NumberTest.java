package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @DisplayName("문자를 받아서 Number 객체를 생성한다")
    @Test
    void create() {
        Number number = new Number("1");
        assertThat(number).isEqualTo(new Number("1"));
    }

    @DisplayName("null 이나 빈칸일 경우, Runtime 에러 발생시킨다")
    @ParameterizedTest
    @NullAndEmptySource
    void valid_number_string(String nullOrEmpty) {
        assertThatThrownBy(() -> new Number(nullOrEmpty))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음수가 있을 경우 Runtime 에러를 발생시킨다")
    @ParameterizedTest
    @CsvSource({"-1","-2"})
    void check_negative_number(String negative) {
        assertThatThrownBy(() -> new Number(negative))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("1과 2를 더하여 3을 반환한다")
    @Test
    void sum() {
        Number one = new Number("1");
        Number two = new Number("2");
        Number three = one.sum(two);
        assertThat(three).isEqualTo(Number.of(3));
    }
}
