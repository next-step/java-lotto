package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {
    @Test
    public void 문자로_입력시_정상동작() {
        String input = "1,2,3,4,5,6";
        Numbers numbers = Numbers.of(input.split(","));

        assertThat(numbers.hasNumber(1)).isTrue();
        assertThat(numbers.hasNumber(2)).isTrue();
        assertThat(numbers.hasNumber(3)).isTrue();
        assertThat(numbers.hasNumber(4)).isTrue();
        assertThat(numbers.hasNumber(5)).isTrue();
        assertThat(numbers.hasNumber(6)).isTrue();
    }

    @Test
    public void 같은_번호_갯수_카운트() {
        Numbers numbers = Numbers.of(1, 2, 3, 4, 5, 6);
        Numbers newNumbers = Numbers.of(1, 2, 3, 4, 5, 10);

        assertThat(numbers.sameNumberCount(newNumbers)).isEqualTo(5);
    }
}