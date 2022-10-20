import domain.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalcuratorTest {

    private static final String DELIMITER = " ";
    Calcurator calcurator = new Calcurator();

    @ParameterizedTest
    @ValueSource(strings = {"   "})
    public void 공백_문자열_expect_result_zero(String text) {

        List<String> inputText = Arrays.asList(text.split(DELIMITER));
        calcurator.calculate(inputText).equals(new Number(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void 빈_문자열_expect_NumberFormatException(String text) {
        assertThatThrownBy(() -> {
            List<String> inputText = Arrays.asList(text.split(DELIMITER));
            calcurator.calculate(inputText);
        }).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2+", "2 + 3 -1"})
    public void 숫자과_사칙연산_공백없음_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> inputText = Arrays.asList(text.split(DELIMITER));
            calcurator.calculate(inputText);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"22", "47 22"})
    public void 문자열_숫자만_입력_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> inputText = Arrays.asList(text.split(DELIMITER));
            calcurator.calculate(inputText);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+-", "+"})
    public void 연산만_입력_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> inputText = Arrays.asList(text.split(DELIMITER));
            calcurator.calculate(inputText);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 @ 5", "12 = 7"})
    public void 연산아닌기호_입력_expect_IllegalArgumentException(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<String> inputText = Arrays.asList(text.split(DELIMITER));
            calcurator.calculate(inputText);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 + 5", "3 - 5 / 2"})
    public void 산식_입력_expect_success(String text) {
            List<String> inputText = Arrays.asList(text.split(DELIMITER));
            calcurator.calculate(inputText);
    }
}
