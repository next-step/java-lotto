package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PickNumbersTest {

    private List<Number> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
        );
    }

    @Test
    @DisplayName("당첨 번호에 포함되어 있는 경우")
    void contains() {
        PickNumbers pickNumbers = new PickNumbers(numbers);
        assertThat(pickNumbers.contains(new Number(3))).isTrue();
    }

    @Test
    @DisplayName("당첨 번호에 포함되어 있지 않는 경우")
    void notContains() {
        PickNumbers pickNumbers = new PickNumbers(numbers);
        assertThat(pickNumbers.contains(new Number(10))).isFalse();
    }
}
