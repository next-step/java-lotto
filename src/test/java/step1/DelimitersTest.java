package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.domain.Delimiter;
import step1.domain.Delimiters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DelimitersTest {
    @Test
    void createWithoutDelimiter() {
        Delimiters delimiters = Delimiters.createWithoutInput();
        assertThat(delimiters).isEqualTo(Delimiters.createWithoutInput());
    }

    @ParameterizedTest
    @CsvSource(value = {";,true","!,false"})
    void createWithDelimiter(String delimiter, boolean expected) {
        Delimiters delimiters = Delimiters.createWithInput(new Delimiter(";"));
        Assertions.assertEquals(delimiters.equals(Delimiters.createWithInput(new Delimiter(delimiter))), expected);
    }
}
