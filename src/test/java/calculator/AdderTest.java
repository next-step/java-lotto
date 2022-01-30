package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.Adder;
import calculator.Token;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AdderTest {

    @Test
    void 더하기() {
        List<Token> tokens = Arrays.asList(
            new Token("1"),
            new Token("2"),
            new Token("3")
        );

        Adder adder = new Adder(tokens);
        int result = adder.calculate();

        assertThat(6).isEqualTo(result);
    }

    @Test
    void 숫자_하나(){
        List<Token> tokens = Arrays.asList(
            new Token("1")
        );

        Adder adder = new Adder(tokens);
        int result = adder.calculate();

        assertThat(1).isEqualTo(result);
    }
}
