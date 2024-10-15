package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 결과를_생성한다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Result actual = new Result(2);
        });
    }

    @Test
    void 결과를_출력한다() {
        Result result = new Result(2);
        int actual = result.value();
        int expected = 2;

        assertThat(actual).isEqualTo(expected);
    }
}
