import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringCalculatorTest {

    StringCalculator mCalculator;

    @BeforeEach
    void setUp() {
        mCalculator = new StringCalculator();
    }

    @Test
    void 쉼표_구분자를_이용한_연산() {
        int result = mCalculator.calculate("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 콜론_구분자를_이용한_연산() {
        int result = mCalculator.calculate("1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 복합_구분자를_이용한_연산() {
        int result = mCalculator.calculate("1:2,3:4");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 빈칸_입력시() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            mCalculator.calculate("");
        });
    }

    @Test
    void 음수_입력시() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            mCalculator.calculate("-1");
        });
    }

    @Test
    void 문자_입력시() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            mCalculator.calculate("A");
        });
    }
}
