package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositiveNumberTest {
    @Test
    @DisplayName("양수가 입력되면 인스턴스가 생성된다")
    void constructor() {
        PositiveNumber positiveNumber = new PositiveNumber(PositiveNumber.MIN_NUMBER_INPUT);
        assertThat(positiveNumber.getNumber()).isEqualTo(PositiveNumber.MIN_NUMBER_INPUT);
    }

    @Test
    @DisplayName("최소값 미만으로 생성시 오류")
    void constructor2() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PositiveNumber(PositiveNumber.MIN_NUMBER_INPUT - 1));
    }
}
