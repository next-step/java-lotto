package lotto.domain;

import calculator.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
class CreditTest {

    @Test
    @DisplayName("PositiveNumber 를 이용하여 마이너스 한 Credit을 얻는다")
    void minus() {
        Credit credit = new Credit("10000");
        Credit minus = credit.substractLottocount(new Credit(new PositiveNumber(2)));
        assertThat(minus.getPurchaseAmount()).isEqualTo(8000);
    }

    @Test
    @DisplayName("minus 한 credit이 음수일 경우 에러를 던진다")
    void throwExceptionWhenNegative() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Credit credit = new Credit("10000");
                credit.substractLottocount(new Credit(new PositiveNumber(11)));
            });
    }
}