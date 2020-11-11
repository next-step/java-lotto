package lotto.utils.calculator;

import lotto.asset.ExceptionConst;
import lotto.exception.BadMoneyException;
import lotto.exception.BadPriceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PurchaseCalculatorTest {

    @ParameterizedTest
    @DisplayName("money 를 price 로 나눈 값을 반환한다.")
    @CsvSource(value = {"9$2$4", "8$2$4", "2$8$0"}, delimiter = '$')
    public void getNumOfLottos(int money, int price, int expected) {
        assertThat(PurchaseCalculator.getNumOfLottos(money,price))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("money 가 0보다 작거나 같으면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "0$true", "1$false"}, delimiter = '$')
    public void getNumOfLottosMoney(int money, boolean negative) {
        int price = 1000;
        if (negative) {
            assertThatExceptionOfType(BadMoneyException.class)
                    .isThrownBy(() -> PurchaseCalculator.getNumOfLottos(money, price))
                    .withMessage(ExceptionConst.BAD_MONEY_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> PurchaseCalculator.getNumOfLottos(money, price));
    }

    @ParameterizedTest
    @DisplayName("money 가 0보다 작거나 같으면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "0$true", "1$false"}, delimiter = '$')
    public void getNumOfLottosMoney2(int money, boolean negative) {
        if (negative) {
            assertThatExceptionOfType(BadMoneyException.class)
                    .isThrownBy(() -> PurchaseCalculator.getNumOfLottos(money))
                    .withMessage(ExceptionConst.BAD_MONEY_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> PurchaseCalculator.getNumOfLottos(money));
    }

    @ParameterizedTest
    @DisplayName("price 가 0보다 작거나 같으면, Exception 이 발생한다.")
    @CsvSource(value = {"-1$true", "0$true", "1$false"}, delimiter = '$')
    public void getNumOfLottosPrice(int price, boolean negative) {
        int money = 1000;
        if (negative) {
            assertThatExceptionOfType(BadPriceException.class)
                    .isThrownBy(() -> PurchaseCalculator.getNumOfLottos(money, price))
                    .withMessage(ExceptionConst.BAD_PRICE_MSG);
            return;
        }
        Assertions.assertDoesNotThrow(() -> PurchaseCalculator.getNumOfLottos(money, price));
    }
}
