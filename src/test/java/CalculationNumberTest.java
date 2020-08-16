import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculationNumberTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,5:4"},
            delimiter = ':')
    void getCalculationNumbers(String input, int result) {
        assertThat(CalculationNumber.getCalculationNumbers(input).getInnerNumbers().size()).isEqualTo(result);
    }

    @Test
    public void convertInputCalculationNumbers_incorrectInput() throws Exception {
        assertThatThrownBy(() -> CalculationNumber.getCalculationNumbers("1,!!,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}