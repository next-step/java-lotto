package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static stringcalculator.util.Converter.convertOperandType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void 문자열을_정수형태의_숫자열로_변환한다() {
        final List<String> inputs = Arrays.asList("1", "2", "3", "4");
        assertThat(convertOperandType(inputs)).hasSize(inputs.size());
    }
}