package StringAddCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringNumberTest {


    @Test
    @DisplayName("더하기")
    public void numberTest() {
        StringNumber six = new StringNumber("6");
        StringNumber three = new StringNumber("3");
        StringNumber nine = six.add(three);

        assertThat(nine).isEqualTo(new StringNumber("9"));
    }

    @Test
    @DisplayName("음수의 경우 예외처리")
    public void negativeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringNumber("-1");
        });
    }

    @Test
    @DisplayName("같은 Number인지 확인")
    public void equality() {
        assertThat(new StringNumber("5")).isEqualTo(new StringNumber("5"));
    }

    @Test
    @DisplayName("숫자가 아닐 경우")
    public void rightNumber() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            new StringNumber(",");
        });
    }

}
