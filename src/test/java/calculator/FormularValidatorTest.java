package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FormularValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 + a * 3 / 2", "1 + 2 * * / 2", "1 + 2 * 3 / "})
    void 산식검증_피연산자오류(String testFormular) {

        String[] formularTokens = testFormular.split(" ");

        System.out.println(Arrays.asList(formularTokens).toString());

        assertThatThrownBy(() -> FormularValidator.validate(formularTokens)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 산식 피연산자 오류");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 & 3 / 2", "1 + 2 3 2 / 2"})
    void 산식검증_연산자오류(String testFormular) {

        String[] formularTokens = testFormular.split(" ");

        assertThatThrownBy(() -> FormularValidator.validate(formularTokens)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 산식 연산자 오류");
    }
}
