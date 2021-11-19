package calcalator.model;

import common.model.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    void setUp() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            numbers.add(new Number(i));
        }
        this.numbers = new Numbers(numbers);

    }

    @Test
    @DisplayName("합계")
    void sumTest() {
        Number sum = this.numbers.sum();
        assertThat(sum.equals(new Number(10))).isTrue();
    }

    @Test
    @DisplayName("String[] 생성자 테스트")
    void name() {
        String[] input = new String[]{"1", "2", "3", "4" };
        Numbers numbers = new Numbers(input);
        assertThat(numbers).isEqualTo(this.numbers);
    }
}
