package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoInputParserTest {
    LottoInputParser parser;
    int upperBound = 45;
    int lowerBound = 1;
    int lottoNumberCount = 6;

    @BeforeEach
    public void setUp() {
        parser = new LottoInputParser(upperBound, lowerBound, lottoNumberCount);
    }

    @Test
    public void getLottoNumbersTestInAnyOrder() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> expected = Arrays.asList(2, 1, 4, 3, 5, 6);
        List<Integer> output = parser.parse(input);
        assertThat(output).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void getLottoNumbersLengthFailTest() {
        String input = "1, 2, 3, 4, 5";
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getLottoNumbersRangeTest() {
        String input = "1, 2, 3, 4, 47";
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getLottoNumbersFailTest() {
        String input = "1, 맘, 3, 4; 5";
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getLottoNumbersNoSpaceInputTest() {
        String input = "1,2,3,4,5,6";
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getLottoNumberRandomGeneratorTest() {
        List<Integer> numbers = parser.getLottoNumbers();
        assertThat(numbers).hasSize(lottoNumberCount);
        assertThat(numbers).allMatch(n -> n >= lowerBound && n <= upperBound);
    }
}
