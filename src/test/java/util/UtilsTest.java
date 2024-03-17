package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void 문자열_배열을_숫자_리스트로_변환한다() {
        // given
        final String[] stringNumbers = {"1", "2", "3", "4", "5", "6"};

        // when
        final List<Integer> numbers = Utils.convertToNumbers(stringNumbers);

        // then
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
