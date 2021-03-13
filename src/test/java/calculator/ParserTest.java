package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void init() {
        parser = new Parser();
    }

    @ParameterizedTest(name = "(',', ':') 로 구분된 문자열에서 수열을 추출한다. - {0}")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3"})
    void makeSequenceFromStringDividedIntoBasicDelimiters(String expression) {
        Sequence sequence = new Sequence(Arrays.asList("1", "2", "3"));

        assertThat(parser.makeSequence(expression)).isEqualTo(sequence);
    }
    
}
