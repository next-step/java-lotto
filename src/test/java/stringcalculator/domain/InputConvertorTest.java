package stringcalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;


class InputConvertorTest {

    @Test
    void inputNullOrEmptyStringTest() {
        List<Integer> integerList = InputConvertor.convert(null);
        assertThat(integerList).contains(0);

        integerList = InputConvertor.convert("");
        assertThat(integerList).contains(0);
    }

    @Test
    void inputOneNumberTest() {
        List<Integer> integerList = InputConvertor.convert("1");
        assertThat(integerList).contains(1);
    }

    @Test
    void inputTwoMoreNumberTest() {
        List<Integer> integerList = InputConvertor.convert("1,2");
        assertThat(integerList).contains(1, 2);

        integerList = InputConvertor.convert("1,2,3");
        assertThat(integerList).contains(1, 2, 3);
    }

    @Test
    public void input_쉼표_또는_콜론_구분자_포함() throws Exception {
        List<Integer> integerList = InputConvertor.convert("1,2:3");
        assertThat(integerList).contains(1, 2, 3);
    }

    @Test
    void inputCustomSeparatorTest() {
        List<Integer> integerList = InputConvertor.convert("//;\n1;2;3");
        assertThat(integerList).contains(1, 2);
    }

    @Test
    public void inputNegativeTest() throws Exception {
        assertThatThrownBy(() -> InputConvertor.convert("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void inputNonNumberTest() throws Exception {
        assertThatThrownBy(() -> InputConvertor.convert("-,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}