package stringcalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 결과를_저장한다() {
        Result actual = new Result(2);
        Result trueExpected = new Result(2);
        Result falseExpected = new Result(3);

        assertThat(actual).isEqualTo(trueExpected);
        assertThat(actual).isNotEqualTo(falseExpected);
    }

    @Test
    void 결과를_출력한다() {
        Result result = new Result(2);
        int actual = result.value();
        int expected = 2;

        assertThat(actual).isEqualTo(expected);
    }
}
