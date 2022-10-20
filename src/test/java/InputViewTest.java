import domain.ArithmeticSign;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {

    InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void 공백문자열입력받기_expect_IllegalArgumentException(String text){
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validInputText(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2+", "2 + 3 -1"})
    public void 숫자과_사칙연산_공백없음_expect_IllegalArgumentException(String text){
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validInputText(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"22", "47 22"})
    public void 문자열_숫자만_입력_expect_IllegalArgumentException(String text){
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validInputText(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+-", "+"})
    public void 연산만_입력_expect_IllegalArgumentException(String text){
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validInputText(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 @ 5", "12 = 7"})
    public void 연산아닌기호_입력_expect_IllegalArgumentException(String text){
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.validInputText(text));
    }
}
