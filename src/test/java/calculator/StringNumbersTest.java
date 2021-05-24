package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringNumbersTest {

    @DisplayName("합계 구하기")
    @Test
    void sum() {
        String[] input = {"1", "2", "3"};
        StringNumbers numbers = new StringNumbers(input);
        int result = numbers.sum();
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("1급 컬렉션 불변 확인 - 컬렉션 변경 시 UnsupportedOperationException 발생")
    @Test
    void immutableCollection() {
        String[] input = {"1", "2", "3"};
        StringNumbers numbers = new StringNumbers(input);
        List<StringNumber> readOnly = numbers.getNumbers();
        assertThatThrownBy(() -> readOnly.add(new StringNumber("4")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}