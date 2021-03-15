package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import stringcalculator.util.Tokenizer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator;

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = stringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Nested
    class StringManipulatiton {
        @Test
        void customTokenizer() {
            String target  = "//;\\n1;2;3";
            assertThat(target.substring(target.indexOf("//")+2, target.indexOf("\\")))
                    .isEqualTo(";");
            assertThat(target.substring(target.indexOf("\\")+2))
                    .isEqualTo("1;2;3");
        }

        @Test
        @DisplayName("커스텀구분자여부")
        void isCustom() {
            Tokenizer tokenizer = new Tokenizer("//;\\n1;2;3");
            assertThat(tokenizer.isCustom()).isTrue();
        }
    }

    @BeforeEach
    void init() {
        stringAddCalculator = new StringAddCalculator();
    }
}
