package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Inputs;
import step1.domain.Number;

import static org.assertj.core.api.Assertions.*;

public class InputsTest {
    @Test
    @DisplayName("구분자가 포함된 문자열을 사용하여 Inputs 객체 생성")
    void createWithDelimiter() {
        assertThat(new Inputs("//;\n1;2;3")).isEqualTo(new Inputs("//;\n1;2;3"));
        assertThat(new Inputs("//;\n1;2;3")).isNotEqualTo(new Inputs("//:\n1:2:3"));
    }

    @Test
    @DisplayName("구분자가 포함되지 않은 문자열을 사용하여 Inputs 객체 생성")
    void createWithoutDelimiter() {
        assertThat(new Inputs("1:2:3")).isEqualTo(new Inputs("1:2,3"));
        assertThat(new Inputs("1:2:3")).isNotEqualTo(new Inputs("1:2,4"));
    }

    @Test
    @DisplayName("Numbers 합")
    void sum() {
        assertThat(new Inputs("1:2:3").sum()).isEqualTo(Number.createFromInt(6));
    }
}
