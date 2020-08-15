import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterCustomDelimiterImplTest {

    @Test
    void ConverterCustomDelimiter_supports() {
        Converter converterCustomDelimiter = new ConverterCustomDelimiterImpl("//;\n1;2;3");
        assertThat(converterCustomDelimiter.supports()).isTrue();
    }

    @Test
    void ConverterCustomDelimite_notSupported() {
        Converter converterCustomDelimiter = new ConverterCustomDelimiterImpl("1,2,3");
        assertThat(converterCustomDelimiter.supports()).isFalse();
    }

    @Test
    void convertInputCalculationNumbers() {
        assertThat(CalculationNumber.getCalculationNumbers("//;\n1;2;3").getInnerNumbers().size()).isEqualTo(3);
    }
}