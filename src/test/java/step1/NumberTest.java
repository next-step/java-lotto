package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    @DisplayName("문자를 받아서 Number 객체 생성")
    void create() {
        Number number = new Number("1");
        assertThat(number).isEqualTo(new Number("1"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 빈칸일 경우, Runtime 에러 발생")
    void valid_number_string(String nullOrEmpty) {
        assertThatThrownBy(() -> new Number(nullOrEmpty))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource({"-1","-2"})
    void check_negative_number(String negative) {
        assertThatThrownBy(() -> new Number(negative))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void sum() {
        Number one = new Number("1");
        Number two = new Number("2");
        int three = one.plus(two);
        assertThat(three).isEqualTo(3);
    }
}
