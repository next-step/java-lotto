package addcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static addcalculator.fixture.NumberFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @DisplayName("Numbers 객체의 총합을 계산한다")
    @Test
    void sum()  {
        Numbers numbers = Numbers.of(Arrays.asList(NUMBER1, NUMBER2, NUMBER3, NUMBER4));

        assertThat(numbers.sum()).isEqualTo(TOTAL_SUM_NUMBER);
    }
}