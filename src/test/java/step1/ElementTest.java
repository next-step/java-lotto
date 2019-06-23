package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ElementTest {

    @Test
    void 정수로_Element를_생성할_수_있다() {
        //Given
        int testValue = 1;
        Element element = Element.from(testValue);
        //When
        //Then
        assertThat(element.getValue()).isEqualTo(testValue);
    }

    @Test
    void 문자열로_Element를_생성할_수_있다() {
        //Given
        String testValue = "1";
        Element element = Element.from(testValue);
        //When
        //Then
        assertThat(element.getValue()).isEqualTo(Integer.parseInt(testValue));
    }

    @Test
    void 음수값이_전달될_경우_RuntimeException이_발생한다() {
        //Given
        int testValue = -1;
        //When
        //Then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Element.from(testValue);
                }).withMessageContaining(Element.ALERT_FOR_NEGATIVE_NUMBER);
    }

    @Test
    void 문자값이_전달될_경우_RuntimeException이_발생한다() {
        //Given
        String invalidString = "안녕!? 내 이름은 문자야 :)";
        String negativeString = "-1";
        //When
        //Then
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Element.from(invalidString);
                    Element.from(negativeString);
                }).withMessageContaining(Element.ALERT_FOR_INVALID_INPUT_VALUE);
    }

}
