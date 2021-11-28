package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Inputs;

import static org.assertj.core.api.Assertions.*;

public class InputsTest {
    @Test
    @DisplayName("구분자가 포함된 문자열인지 확인")
    void isHaveDelimiters() {
        assertThat(Inputs.isHaveDelimiters("//;\n1;2;3")).isTrue();
        assertThat(Inputs.isHaveDelimiters("/;\n1;2;3")).isFalse();
    }

    @Test
    @DisplayName("구분자가 포함된 문자열을 사용하여 Inputs 객체 생성")
    void createWithDelimiter() {
        assertThat(Inputs.createWithDelimiters("//;\n1;2;3")).isEqualTo(Inputs.createWithDelimiters("//;\n1;2;3"));
        assertThat(Inputs.createWithDelimiters("//;\n1;2;3")).isNotEqualTo(Inputs.createWithDelimiters("//:\n1:2:3"));
    }

    @Test
    @DisplayName("구분자가 포함되지 않은 문자열을 사용하여 Inputs 객체 생성")
    void createWithoutDelimiter() {
        assertThat(Inputs.createWithoutDelimiters("1:2:3")).isEqualTo(Inputs.createWithoutDelimiters("1:2,3"));
        assertThat(Inputs.createWithoutDelimiters("1:2:3")).isNotEqualTo(Inputs.createWithoutDelimiters("1:2,4"));
    }
}
