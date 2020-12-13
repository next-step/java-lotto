package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;


class InputConvertorTest {

    @Test
    @DisplayName("입력이 Null 이거나 빈 문자열일 경우 변환 테스트")
    void inputNullOrEmptyStringTest() {
        List<Integer> integerList = InputConvertor.convert(null);
        assertThat(integerList).contains(0);

        integerList = InputConvertor.convert("");
        assertThat(integerList).contains(0);
    }

    @Test
    @DisplayName("입력이 정수 1개일 경우 변환 테스트")
    void inputOneNumberTest() {
        List<Integer> integerList = InputConvertor.convert("1");
        assertThat(integerList).contains(1);
    }

    @Test
    @DisplayName("입력이 정수 2개 이상일 경우 변환 테스트")
    void inputTwoMoreNumberTest() {
        List<Integer> integerList = InputConvertor.convert("1,2");
        assertThat(integerList).contains(1, 2);

        integerList = InputConvertor.convert("1,2,3");
        assertThat(integerList).contains(1, 2, 3);
    }

    @Test
    @DisplayName("구분자가 쉽표 또는 콜론자 포함일 경우 변환 테스트")
    public void input_쉼표_또는_콜론_구분자_포함() throws Exception {
        List<Integer> integerList = InputConvertor.convert("1,2:3");
        assertThat(integerList).contains(1, 2, 3);
    }

    @Test
    @DisplayName("구분자가 커스텀 문자일 경우 변환 테스트")
    void inputCustomSeparatorTest() {
        List<Integer> integerList = InputConvertor.convert("//;\n1;2;3");
        assertThat(integerList).contains(1, 2);
    }

    @Test
    @DisplayName("음수가 입력에 있을시 RuntimeException 발생하는지 테스트")
    public void inputNegativeTest() throws Exception {
        assertThatThrownBy(() -> InputConvertor.convert("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("정수가 아닌 값이 입력에 있을시 RuntimeException 발생하는지 테스트")
    public void inputNonNumberTest() throws Exception {
        assertThatThrownBy(() -> InputConvertor.convert("-,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}