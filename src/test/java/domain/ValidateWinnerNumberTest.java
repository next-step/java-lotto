package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateWinnerNumberTest {

    @DisplayName("로또숫자 중복 테스트")
    @Test
    void validateStringsTest() {
        String input = "1,2,3,4,5,5";
        String inputs[] = input.split(",");

        int bonus = 7;

        assertThatThrownBy(() -> {
            new ValidateWinnerNumber(inputs, bonus);

        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또숫자 범위 테스트")
    @Test
    void validateNumberRangeTest() {
        String input = "1,2,3,4,54,90";
        String inputs[] = input.split(",");

        int bonus = 7;

        assertThatThrownBy(() -> {
            new ValidateWinnerNumber(inputs, bonus);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("오류!!");
    }

    @DisplayName("입력 숫자가 6개인지 테스트")
    @Test
    void validateNumberIsSixTest() {
        String input = "1,2,3,4,5";
        String inputs[] = input.split(",");

        int bonus = 7;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ValidateWinnerNumber(inputs, bonus);

        }).withMessageContaining("숫자 개수 에러");
    }
}
