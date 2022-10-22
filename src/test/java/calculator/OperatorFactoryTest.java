package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorFactoryTest {
    @Test
    void test_plus() {
        assertThat(OperatorFactory.create("+")).isInstanceOf(Plus.class);
    }

    @Test
    void test_minus() {
        assertThat(OperatorFactory.create("-")).isInstanceOf(Minus.class);
    }

    @Test
    void test_multiply() {
        assertThat(OperatorFactory.create("*")).isInstanceOf(Multiply.class);
    }

    @Test
    void test_divide() {
        assertThat(OperatorFactory.create("/")).isInstanceOf(Divide.class);
    }

    @Test
    void test_error() {
        assertThatIllegalArgumentException().isThrownBy(() -> OperatorFactory.create("."));
    }
}
