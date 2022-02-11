package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AdderTest {

    @Test
    void 더하기() {
        String[] parsedInput = {"1", "2", "3"};
        Adder adder = new Adder(new Token(parsedInput));
        int result = adder.calculate();

        assertThat(6).isEqualTo(result);
    }

    @Test
    void 숫자_하나만_들어왔을_경우_결과값은_그_숫자() {
        String[] parsedInput = {"3"};
        Adder adder = new Adder(new Token(parsedInput));
        int result = adder.calculate();
        assertThat(3).isEqualTo(result);
    }
}
