package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringPlusCalcTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3" , "1,2:3" , "//;\n1;2;3"})
    void splitAndSum(String entered) {
        int result = StringPlusCalc.splitAndSum(entered);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,-3", "1,2,C"})
    void enterNotNumberOrNegativeNumber(String entered) {
        assertThatThrownBy(() -> {
            StringPlusCalc.splitAndSum(entered);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource({",", "''"})
    void enterEmptyOrNull(String entered) {
        int result = StringPlusCalc.splitAndSum(entered);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1" , "2", "3"})
    public void enterOneNumber(String entered) {
        int result = StringPlusCalc.splitAndSum(entered);
        assertThat(result).isEqualTo(Integer.parseInt(entered));
    }
}