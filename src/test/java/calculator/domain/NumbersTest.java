package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NumbersTest {

    @Test
    @DisplayName("문자열을 Numbers 객체로 변환 테스트")
    void texts_to_numbers_test() {
        // given
        String[] texts = {"1", "2", "3"};

        // when
        Numbers numbers = new Numbers(texts);

        // then
        assertThat(numbers.getNumbers()).hasSize(3);
        assertThat(numbers.getNumbers()).containsExactly(Number.of("1"), Number.of("2"), Number.of("3"));
    }

    @Test
    @DisplayName("문자열 합을 구하는 테스트")
    void numbers_sum_test() {
        // given
        String[] texts = {"4", "5", "6"};

        // when
        Numbers numbers = new Numbers(texts);
        int result = numbers.sum();

        // then
        assertThat(result).isEqualTo(15);
    }

}
