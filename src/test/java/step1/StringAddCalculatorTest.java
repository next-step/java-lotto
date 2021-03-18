package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Number;
import step1.domain.Numbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        Numbers result = new Numbers(null);
        assertThat(result).isEqualTo(new Numbers(null));

        result = new Numbers("");
        assertThat(result).isEqualTo(new Numbers(""));
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        Number result = new Number("1");
        assertThat(result).isEqualTo(new Number(1));
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        Numbers result = new Numbers("1,2");
        assertThat(result.sum()).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        Numbers result = new Numbers("1,2:3");
        assertThat(result.sum()).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        Numbers result = new Numbers("//;\n1;2;3");
        assertThat(result.sum()).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> new Number("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
