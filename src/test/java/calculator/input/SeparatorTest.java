package calculator.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SeparatorTest {

    @Test
    void split() {
        String str = "1 + 2 + 3";
        Separator separator = new Separator(str);
        String[] strs = separator.split();
        assertThat(strs).hasSize(5);
    }

    @Test
    void 공백_null_잘못입력() {
        String str = "";
        Separator separator = new Separator(str);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            separator.split();
        }).withMessage("계산식이 빈값입니다.");

        String str2 = null;
        Separator separator2 = new Separator(str2);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            separator.split();
        }).withMessage("계산식이 빈값입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+ 2", "1 +  2", "rse"})
    void 계산식_잘못입력(String str) {
        Separator separator = new Separator(str);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            separator.split();
        }).withMessage("입력값이 올바르지 않습니다.");
    }

    @Test
    void 기호와숫자분리() {
        String str = "1 + 2 + 3";
        Separator separator = new Separator(str);
        Numbers numbers = new Numbers();
        assertThat(separator.separateNumbers().getNumbers()).hasSize(3);
    }

}
