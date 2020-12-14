package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTextTest {

    @Test
    void isEmpty_null_또는_빈문자() {
        boolean flag = new InputText(null).isEmpty();
        assertThat(flag).isTrue();

        flag = new InputText("").isEmpty();
        assertThat(flag).isTrue();
    }
}
