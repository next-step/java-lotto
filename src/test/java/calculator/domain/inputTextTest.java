package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class inputTextTest {
    @Test
    void create() {
        Assertions.assertThat(new InputText("1,2,3")).isEqualToComparingFieldByField(new InputText("1,2,3"));
    }

    @Test
    void splitInputTextTest() {
        Assertions.assertThat(new InputText("1,2:3").splitInputText()).isEqualTo(new InputText("1,2,3").splitInputText());
    }
}
