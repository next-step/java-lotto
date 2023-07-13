package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.domain.game.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentTest {

    @DisplayName("투입 금액 입력값이 숫자가 아닌 경우 예외 발생한다")
    @Test
    void 투입_금액_입력_문자() {
        String value = "aaa";

        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> new Payment(value))
            .withMessage("숫자를 입력해야 합니다");
    }

    @DisplayName("null이면 에러가 발생한다")
    @Test()
    void 투입_금액_검증_실패_null() {
        String value = null;

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Payment(value))
            .withMessage("값을 입력해 주세요");
    }

    @DisplayName("비어있거나 공백인 경우 에러가 발생한다")
    @ValueSource(strings = {"", " ", "  "})
    @ParameterizedTest()
    void 투입_금액_검증_실패_공백(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Payment(value))
            .withMessage("값을 입력해 주세요");
    }

    @DisplayName("투입한 금액이 1,000원 미만이면 예외 발생한다")
    @Test()
    void 최소_투입_금액_검증() {
        String value = "999";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Payment(value))
            .withMessage("1,000원 이상 투입해 주세요");
    }

    @DisplayName("투입한 금액만큼 로또 구매 갯수를 반환한다")
    @Test
    void 로또_구입_갯수() {
        String value1 = "12000";
        String value2 = "1000";

        Payment payment1 = new Payment(value1);
        Payment payment2 = new Payment(value2);

        assertThat(payment1.getLottoCount()).isEqualTo(12);
        assertThat(payment2.getLottoCount()).isEqualTo(1);
    }

}
