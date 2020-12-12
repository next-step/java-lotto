package stringcalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


class InputParserTest {

    @Test
    void inputNullOrEmptyStringTest() {
        List<Integer> integerList = InputParser.convert(null);
        assertThat(integerList).contains(0);

        integerList = InputParser.convert("");
        assertThat(integerList).contains(0);
    }

    @Test
    void inputOneNumberTest() {
        List<Integer> integerList = InputParser.convert("1");
        assertThat(integerList).contains(1);
    }

    @Test
    void inputTwoMoreNumberTest() {
        List<Integer> integerList = InputParser.convert("1,2");
        assertThat(integerList).contains(1, 2);

        integerList = InputParser.convert("1,2,3");
        assertThat(integerList).contains(1, 2, 3);
    }
}