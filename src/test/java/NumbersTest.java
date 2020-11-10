import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
    @Test
    @DisplayName(",를 기준으로 string input을 숫자로 나누기")
    void from() {
        String input = "1,2";

        Numbers from = Numbers.from(input);

        assertThat(from).isEqualTo(new Numbers(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName(",를 기준으로 string input을 숫자로 나누기")
    void sum() {
        List<Integer> numberList = Arrays.asList(1, 2);

        Numbers numbers = new Numbers(numberList);
        int sum = numbers.sum();

        assertThat(sum).isEqualTo(3);
    }
}