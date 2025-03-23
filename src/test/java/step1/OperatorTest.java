package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    void 연산자는_정해진_기호를_가진다() {
        Operator operator = Operator.PLUS;
        assertThat(operator.symbol()).isEqualTo('+');
    }
}
