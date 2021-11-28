package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.domain.Delimiter;
import step1.domain.Delimiters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DelimitersTest {
    @Test
    @DisplayName("입력 구분자가 없을 경우 생성자 test")
    void createWithoutDelimiter() {
        Delimiters delimiters = Delimiters.createWithoutInput();
        assertThat(delimiters).isEqualTo(Delimiters.createWithoutInput());
    }

    @ParameterizedTest
    @CsvSource(value = {";,true","!,false"})
    @DisplayName("입력 구분자가 있을 경우 생성자 test")
    void createWithDelimiter(String delimiter, boolean expected) {
        Delimiters delimiters = Delimiters.createWithInput(new Delimiter(";"));
        Assertions.assertEquals(delimiters.equals(Delimiters.createWithInput(new Delimiter(delimiter))), expected);
    }

    @Test
    @DisplayName("String split를 위한 구분자들 합치기")
    void joining() {
        assertThat(Delimiters.createWithoutInput().joining()).isEqualTo(",|:");
        assertThat(Delimiters.createWithInput(new Delimiter("$")).joining()).isEqualTo("$");
    }
}
