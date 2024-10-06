package stringcalculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static stringcalculator.model.Result.ONLY_ALLOWED_NUMBER;

public class ResultTest {
    @Test
    void 결과_문자열을_받아_저장한다() {
        Result actual = new Result("2");
        Result trueExpected = new Result("2");
        Result falseExpected = new Result("3");

        assertThat(actual).isEqualTo(trueExpected);
        assertThat(actual).isNotEqualTo(falseExpected);
    }

    @Test
    void 결과_문자열은_숫자문자가_아니면_오류() {
        assertThatThrownBy(() -> {
            Result actual = new Result("U");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_ALLOWED_NUMBER);
    }
}
