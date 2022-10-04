package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-10-04
 */
class OperatorBoxTest {

    @Test
    void operate() {
        OperatorBox operatorBox = new OperatorBox();
        operatorBox.add(new InputValue("+"));

        assertThat(operatorBox.operate(new CalculateResult(5), new InputValue("5"))).isEqualTo(new CalculateResult(10));
    }

    @Test
    void operate2() {
        OperatorBox operatorBox = new OperatorBox();

        assertThat(operatorBox.operate(new CalculateResult(5), new InputValue("5"))).isEqualTo(new CalculateResult(5));
    }
}