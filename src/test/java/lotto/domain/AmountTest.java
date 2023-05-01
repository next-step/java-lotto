package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class AmountTest {

    @Test
    @DisplayName("로또 장수 0개 미만일 때 에러 테스트")
    void lessThenMinimumTest() {
        assertThatThrownBy(() -> Amount.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 이상 수를 입력해주세요");
    }

    @Test
    @DisplayName("구입 금액보다 많을 때 에러 테스트")
    void overThenTotalAmount() {
        Money price = Money.from(5000);
        Amount manualAmount = Amount.from(6);

        assertThatThrownBy(() -> manualAmount.calculateAutoLottos(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액보다 많습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"5,0", "3,2", "1,4", "0,5"})
    @DisplayName("구입 금액보다 이하일 때 통과 테스트")
    void lessThenTotalAmount(int manualAmount, int autoAmount) {
        Money price = Money.from(5000);
        Amount amount = Amount.from(manualAmount);

        assertThat(amount.calculateAutoLottos(price))
                .usingRecursiveComparison()
                .isEqualTo(Amount.from(autoAmount));
    }

}