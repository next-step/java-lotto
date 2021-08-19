package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumbersTest {
    @Test
    @DisplayName("쉼표와 콜론을 구분자로 문자열을 분리하는지 테스트")
    void splitString() {
        List<Integer> result = Numbers.toListOfInt("1,2");
        assertThat(result).isEqualTo(Arrays.asList(1, 2));

        result = Numbers.toListOfInt("2:3");
        assertThat(result).isEqualTo(Arrays.asList(2, 3));
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리하는지 테스트")
    void splitStringByCustom() {
        List<Integer> result = Numbers.toListOfInt("//%\n1%3%5");
        assertThat(result).isEqualTo(Arrays.asList(1, 3, 5));
    }

    @Test
    @DisplayName("숫자 문자를 Int값으로 바꾸는지 테스트")
    void parseInt() {
        List<Integer> result = Numbers.toListOfInt("1");
        assertThat(result).isEqualTo(Collections.singletonList(1));
    }

    @Test
    @DisplayName("빈 문자열이나 null로 전달될 경우 0으로 반환하는지 테스트")
    void parseIntToZero() {
        List<Integer> result = Numbers.toListOfInt(null);
        assertThat(result).isEqualTo(Collections.singletonList(0));

        result = Numbers.toListOfInt("");
        assertThat(result).isEqualTo(Collections.singletonList(0));
    }

    @Test
    @DisplayName("숫자가 아닌 값이나 음수가 전달될 경우 RuntimeException이 나는지 테스트")
    void parseIntNotPositiveNumber() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            Numbers.toListOfInt("4,-1,8");
        });

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
             Numbers.toListOfInt("6,a,10");
        });
    }
}