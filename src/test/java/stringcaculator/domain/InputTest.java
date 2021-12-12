package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {
    Input useCustomDelimeterInput = new Input("//;\n1;2;3");
    Input useGeneralDelimeterInput = new Input("1,2:3");
    String[] result = {"1","2","3"};

    @Test
    @DisplayName("customParameter 사용 여부를 정상적으로 반환하는지 확인합니다.")
    void useCustomDelimeter() {
        assertThat(new Delimiter(useCustomDelimeterInput).useCustomDelimeter()).isTrue();
        assertThat(new Delimiter(useGeneralDelimeterInput).useCustomDelimeter()).isFalse();
    }

    @Test
    @DisplayName("정상적으로 Input을 자르는지 확인합니다.")
    void splitedInput() {
        assertThat(new Delimiter(useCustomDelimeterInput).splitedInput()).isEqualTo(result);
        assertThat(new Delimiter(useGeneralDelimeterInput).splitedInput()).isEqualTo(result);
    }
}