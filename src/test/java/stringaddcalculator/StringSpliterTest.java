package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSpliterTest {

    @Test
    @DisplayName("구분자가 ','인경우 잘쪼개는지 확인한다")
    void testSplit() {
        // given
        StringSpliter stringSpliter = StringSpliter.of("1,2");
        // when
        List<Integer> numbers = stringSpliter.split();
        // then
        assertThat(numbers.size()).isEqualTo(2);
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
    }

    @Test
    @DisplayName("구분자가 ',' 또는 ':'인경우 잘쪼개는지 확인한다")
    void testSplit2() {
        // given
        StringSpliter stringSpliter = StringSpliter.of("1,2:3");
        // when
        List<Integer> numbers = stringSpliter.split();
        // then
        assertThat(numbers.size()).isEqualTo(3);
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(3));
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한경우 잘쪼개는지 확인한다")
    void testSplit3() {
        // given
        StringSpliter stringSpliter = StringSpliter.of("//;\n1;2;3");
        // when
        List<Integer> numbers = stringSpliter.split();
        // then
        assertThat(numbers.size()).isEqualTo(3);
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(3));
    }

    @Test
    @DisplayName("구분자없이 숫자가 하나만 있는 경우를 확인한다")
    void testSplit4() {
        // given
        StringSpliter stringSpliter = StringSpliter.of("1");
        // when
        List<Integer> numbers = stringSpliter.split();
        // then
        assertThat(numbers.size()).isEqualTo(1);
        assertTrue(numbers.contains(1));
    }
}
