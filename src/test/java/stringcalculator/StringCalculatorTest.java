package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    InputStream inputStream;
    OutputStream outputStream;

    @BeforeEach
    void 초기화() {
        inputStream = new ByteArrayInputStream("1 + 2".getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 수식입력() {
        StringCalculator.formula();
        assertThat(outputStream.toString()).containsPattern("");
    }

    @Test
    void 계산기() {
        assertThat(StringCalculator.result(new Formula("1 + 2"))).isEqualTo(3);
    }

}
