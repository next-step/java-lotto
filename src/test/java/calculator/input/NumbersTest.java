package calculator.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumbersTest {

    @Test
    void 정상적으로_숫자추출() {
        String str = "1 + 2 + 3";
        String[] strs = str.split(" ");

        Numbers numbers = new Numbers();
        numbers.generateNumbers(strs);

        assertThat(numbers.getNumbers()).hasSize(3);
    }

    @Test
    void 정상적인_숫자_추출이_아닌경우() {
        String str = "1 + 2 + ㅎ";
        String[] strs = str.split(" ");

        Numbers numbers = new Numbers();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            numbers.generateNumbers(strs);
        }).withMessage("숫자가 아닙니다.");

        String str2 = "zz+_ +_+ + +";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            numbers.generateNumbers(strs);
        }).withMessage("숫자가 아닙니다.");

    }


}
