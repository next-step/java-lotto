package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValueTest {
    @Test
    @DisplayName("InputValue 생성자 테스트")
    public void create() {
        assertThat(new InputValue("1")).isEqualTo(new InputValue("1"));
    }
}
