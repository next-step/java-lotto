package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountOfMoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "14,000", "-14000", "0", "900"})
    @DisplayName("파라미터로 주어진 amountOfMoney가 양의 정수가 아니거나 로또 1장의 가격보다 작다면 IllegalArgumentException이 발생한다.")
    void testInstanceCreationFailCase(String amountOfMoneyInput) {
        assertThatThrownBy(() -> PurchaseAmountOfMoney.valueOf(amountOfMoneyInput))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "14001:14"}, delimiter = ':')
    @DisplayName("numberOfLottoToPurchase(): 구매금액으로 사게되는 로또의 개수를 반환한다.")
    void testNumberOfLottoToPurchase(String amountOfMoneyInput, int expected) {
        PurchaseAmountOfMoney purchaseAmountOfMoney = PurchaseAmountOfMoney.valueOf(amountOfMoneyInput);
        assertThat(purchaseAmountOfMoney.numberOfLottoToPurchase()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:0:0", "14000:5000:0.35", " 14001:5000:0.35", "14000:50000:3.57", "14500:2000000000:142857.14"}, delimiter = ':')
    @DisplayName("rateOfReturn(): 당첨금액에 따른 수익률을 소수점 두째자리까지 구합니다.")
    void testRateOfReturn(String amountOfMoneyInput, int winningAmountOfMoney, double expected) {
        PurchaseAmountOfMoney purchaseAmountOfMoney = PurchaseAmountOfMoney.valueOf(amountOfMoneyInput);
        assertThat(purchaseAmountOfMoney.rateOfReturn(winningAmountOfMoney)).isEqualTo(expected);
    }
}
