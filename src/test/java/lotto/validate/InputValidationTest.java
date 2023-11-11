package lotto.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @DisplayName("로또 구입 성공")
    @Test
    void 구입_금액_1000원() {
        // given
        int input = 1000;
        // when
        // then
        inputValidation.inputValidate(input);
    }

    @DisplayName("로또 구입 실패")
    @Nested
    class 실패테스트 {

        @DisplayName("로또 구입 1000 미만 입력")
        @Test
        void 구입_금액_1000원_미만() {
            // given
            int input = 999;
            // when
            // then
            assertThatIllegalArgumentException().isThrownBy(() -> {
                inputValidation.inputValidate(input);
            }).withMessageMatching("로또 구입 금액은 1000원 이상 입력해야 합니다.");
        }

        @DisplayName("로또 구입 -1000 입력")
        @Test
        void 구입_금액_음수() {
            // given
            int input = -1;
            // when
            // then
            assertThatIllegalArgumentException().isThrownBy(() -> {
                inputValidation.inputValidate(input);
            }).withMessageMatching("로또 구입 금액은 1000원 이상 입력해야 합니다.");
        }

        @DisplayName("로또 구입 1001 입력")
        @Test
        void 구입_금액_1001원_입력() {
            // given
            int input = 1001;
            // when
            // then
            assertThatIllegalArgumentException().isThrownBy(() -> {
                inputValidation.inputValidate(input);
            }).withMessageMatching("로또 구입 금액은 1000원 단위로 가능합니다.");
        }
    }
}
