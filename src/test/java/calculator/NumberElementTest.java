package calculator;

import model.NumberElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberElementTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "55"})
    void parseStringToNumber(String stringValue) {

        NumberElement element = new NumberElement(stringValue);

        assertThat(element).isEqualTo(new NumberElement(Integer.parseInt(stringValue)));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void parseEmptyOrNull(String stringValue) {

        NumberElement element = new NumberElement(stringValue);

        assertThat(element).isEqualTo(new NumberElement(0));
    }

    @DisplayName("숫자 이외의 문자변환 오류")
    @Test
    void parseNANException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new NumberElement("!");
        });
    }

    @DisplayName("음수 입력 오류")
    @Test
    void parseNegativeException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new NumberElement("-1");
        }).withMessageStartingWith("음수");
    }
}