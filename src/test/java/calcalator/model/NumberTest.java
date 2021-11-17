package calcalator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {


    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        Number number = new Number("1");
        assertThat(number.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("equals 테스트")
    void equals() {
        Number number = new Number("1");
        assertThat(number.equals(new Number("1"))).isTrue();
    }

    @Test
    @DisplayName("숫자 더하기 테스트")
    void plus() {
        Number number = new Number("1");
        Number other = new Number("3");
        number.plus(other);
        assertThat(number.equals(new Number(4))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"t", "-1"})
    @DisplayName("숫자 외 문자, 음수 파싱 테스트")
    void parse() {
        assertThatThrownBy(() -> new Number("qq")).isInstanceOf(RuntimeException.class);
    }
}
