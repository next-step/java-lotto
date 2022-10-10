package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValuesTest {
    Values values;

    @BeforeEach
    void init() {
        values = new Values();
    }

    @Test
    void addValues() {
        values.addValues("1");
        values.addValues("-");

        assertThat(values.pollOperand()).isEqualTo(1);
        assertThat(values.pollOperator()).isEqualTo("-");
    }

    @Test
    void 사칙연산이_아닌_경우() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            values.addValues("--")
        );
    }
}
