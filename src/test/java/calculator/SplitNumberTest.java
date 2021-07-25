package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitNumberTest {

    @DisplayName("입력값을 모두 더한 값을 리턴한다.")
    @Test
    void input_sum() {
        SplitNumber splitNumber = new SplitNumber(new String[]{"1", "10", "12"});

        assertThat(splitNumber.splitNumberToInt()).isEqualTo(23);
    }

}