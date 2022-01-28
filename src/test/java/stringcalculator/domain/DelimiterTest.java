package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @ValueSource(strings = {"1,2", "1:2"})
    @ParameterizedTest
    void 기본_문자열을_쉼표_혹은_콜론으로_구분한다(String input) {
        Delimiter delimiter = new Delimiter(input);
        List<String> result = delimiter.getNumbers();
        assertThat(result).hasSize(2);
    }
}