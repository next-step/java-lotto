package calculator;

import calculator.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberTest {

    @DisplayName("원시값 포장이 된 Number를 생성할 경우, 생성자로 넘긴 매개변수를 값으로 가진다.")
    @Test
    void constructor() {
        final Number number = new Number(1);
        assertThat(number.value()).isEqualTo(1);
    }

}
