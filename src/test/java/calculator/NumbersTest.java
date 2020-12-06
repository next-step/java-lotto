package calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자들(Numbers) 테스트")
public class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = Numbers.of(1, 2, 3, 4, 5);
    }

    @DisplayName("숫자들은 숫자로 구성되어 있다.")
    @Test
    void create() {
        // then
        assertThat(numbers).isNotNull();
    }

    @DisplayName("숫자의 합을 구할 수 있다.")
    @Test
    void sum() {
        // when
        Number sum = numbers.sum();

        // then
        assertThat(sum).isEqualTo(Number.valueOf(15));
    }
}
