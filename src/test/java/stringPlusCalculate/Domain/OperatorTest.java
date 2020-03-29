package stringPlusCalculate.Domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 2 3:6", "0 3 5:8"}, delimiter = ':')
    void plusTest(String input, String expected) {
        List<Double> resultList = Arrays.stream(input.split(" ")).mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());

        Double result = Operator.PLUS.calc(resultList);

        assertThat(result).isEqualTo(Double.parseDouble(expected));
    }

    @Test
    void plusTest() {
        List<Double> resultList = new ArrayList<>();

        Double result = Operator.PLUS.calc(resultList);

        assertThat(result).isEqualTo(0.0);
    }


}
