package domain;

import org.junit.jupiter.api.Test;

import static domain.InputValue.checkCustomDelimiter;
import static domain.InputValue.inputValueValidate;
import static org.assertj.core.api.Assertions.assertThat;

public class InputValueTest {
    @Test
    void isNull() {
        assertThat(inputValueValidate("")).isEqualTo(0);
        assertThat(inputValueValidate(null)).isEqualTo(0);
    }

    @Test
    void isOnly() {
        assertThat(inputValueValidate("3")).isEqualTo(3);
        assertThat(inputValueValidate("7")).isEqualTo(7);
    }

    @Test
    void 컴마로_구분() {
        assertThat(inputValueValidate("3,2")).isEqualTo(5);
    }

    @Test
    void 콜론으로_구분() {
        assertThat(inputValueValidate("3:2")).isEqualTo(5);
        assertThat(inputValueValidate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_지정() {
        assertThat(inputValueValidate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_체크() {
        assertThat(checkCustomDelimiter("//;\n1;2;3")).hasSize(3);
        assertThat(checkCustomDelimiter("//;\n1;2;3")).containsExactly("1","2","3");
    }
}
