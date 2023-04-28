package stringcalculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {
    private final Parser parser = new Parser("2 + 3 * 4 / 2");

    @Test
    void 사칙연산담기() {
        String[] symbols = {"+", "*", "/"};
        List<String> expectedSymbols = new ArrayList<>(Arrays.asList(symbols));

        assertThat(parser.operators()).isEqualTo(expectedSymbols);
    }

    @Test
    void 숫자담기() {
        double[] numbers = {2, 3, 4, 2};
        List<Double> expectedNumbers = new ArrayList<>();
        for (double number : numbers) {
            expectedNumbers.add(number);
        }

        assertThat(parser.numbers()).isEqualTo(expectedNumbers);
    }
}
