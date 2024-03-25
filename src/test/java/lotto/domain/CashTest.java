package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CashTest {

    @DisplayName("Cash는 음수를 값으로 가질 수 없다.")
    @Test
    void constructor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cash(-1))
                .withMessage("현금은 마이너스 통장이 아닙니다.");
    }

    @DisplayName("buyableAmount는 제품 금액에 따른 구매 가능 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "800,0", "1000,1", "3400,3"})
    void buyableAmount(int cash, int expectAmount) {
        assertThat(new Cash(cash).buyableAmount(new Cash(1000)))
                .isEqualTo(expectAmount);
    }

    @DisplayName("buyableAmount에 매개변수로 넘기는 제품 금액은 음수나 0이 될 수 없다.")
    @Test
    void buyableAmount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cash(1000).buyableAmount(new Cash(0)));
    }

    @DisplayName("zeroOrLessThanZero는 Cash의 값이 0인지 검사한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,false", "0,true"})
    void zeroOrLessThanZero(long value, boolean expectResult) {
        assertThat(new Cash(value).equalsZero())
                .isEqualTo(expectResult);
    }
}
