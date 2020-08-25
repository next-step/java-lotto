package utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static utility.UserInput.validateNumberIsSix;

public class UserInputTest {

    @DisplayName("로또숫자 중복 테스트")
    @Test
    void validateStringsTest() {
        String input = "1,2,3,4,5,5";
        String inputs[] = input.split(",");

        assertThatThrownBy(() -> {
            UserInput.validateStringsDuplicate(inputs);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또숫자 범위 테스트")
    @Test
    void INT_ZEROangeTest() {
        String input = "1,2,3,4,54,90";
        String inputs[] = input.split(",");

        assertThatThrownBy(() -> {
            INT_ZEROange(inputs);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("오류!!");
    }

    @DisplayName("입력 숫자가 6개인지 테스트")
    @Test
    void validateNumberIsSixTest() {
        String input = "1,2,3,4,5";
        String inputs[] = input.split(",");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            validateNumberIsSix(inputs);
        }).withMessageContaining("숫자 개수 에러");
    }
}
