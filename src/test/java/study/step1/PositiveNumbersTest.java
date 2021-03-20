package study.step1;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step1.domain.PositiveNumber;
import study.step1.domain.PositiveNumbers;

public class PositiveNumbersTest {

    @Test
    @DisplayName("합계 테스트")
    public void sum() {
        PositiveNumbers numbers = new PositiveNumbers();
        numbers.add(new PositiveNumber("0"));
        numbers.add(new PositiveNumber("1"));
        assertThat(numbers.sum()).isEqualTo(1);
    }
}
