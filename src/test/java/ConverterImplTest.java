import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConverterImplTest {

    @Test
    void converterImpl_supports() {
        Converter converter = new ConverterImpl("1,2,3");
        assertThat(converter.supports()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,5:4"},
            delimiter = ':')
    void convertInputCalculationNumbers(String input, int result) {
        assertThat(CalculationNumber.getCalculationNumbers(input).getInnerNumbers().size()).isEqualTo(result);
    }

    @Test
    public void convertInputCalculationNumbers_incorrectInput() throws Exception {
        assertThatThrownBy(() -> CalculationNumber.getCalculationNumbers("1,!!,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}