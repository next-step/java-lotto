package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    InputStream inputStream;

    @BeforeEach
    void 초기화() {
        inputStream = new ByteArrayInputStream("1 + 2".getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
    }

    @Test
    void 계산기() {
        StringCalculator calculator = new StringCalculator(new Formula("1 + 2"));
        calculator.calculate();
        assertThat(calculator.result()).isEqualTo(new Number("3"));
    }

}
