package lotto.domain.purchase;

import lotto.domain.purchase.Amount;
import lotto.domain.purchase.Cash;
import lotto.domain.purchase.LotteryShop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryShopTest {

    @DisplayName("복권가게는 가지고 있는 현금보다 많은 수동 복권을 구매할 수 없다.")
    @Test
    void purchaseManual() {
        final Cash cash = new Cash(10000);
        final Amount amount = new Amount(11);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LotteryShop.purchaseManualAndChange(cash, amount));
    }

    @DisplayName("복권가게는 수동복권이 구매가능할 경우, 잔돈을 거슬러 준다.")
    @ParameterizedTest(name = "{0}원으로 {1}개사면 {2}원을 거슬러 준다.")
    @CsvSource(value = {"10000,1,9000", "10000,10,0"})
    void purchaseManual(long cash, int amount, long expectChange) {
        assertThat(LotteryShop.purchaseManualAndChange(new Cash(cash), new Amount(amount)).value())
                .isEqualTo(new BigDecimal(expectChange));
    }

    @DisplayName("복권가게는 내가 선택한 번호들을, 로또로 교환해준다.")
    @Test
    void exchangeNumbersToLottos() {
        final String[][] selectedNumbers = {{"1", "2", "3", "4", "5", "6"}};

        assertThat(LotteryShop.exchangeNumbersToLottos(selectedNumbers).size())
                .isEqualTo(1);
    }

    @DisplayName("복권가게는 지불한 금액으로 구매할 수 있는 만큼 복권을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "800,0", "1000,1", "3400,3"})
    void purchaseAuto(int cash, int expectAmount) {
        assertThat(LotteryShop.purchaseAuto(new Cash(cash)).size())
                .isEqualTo(expectAmount);
    }
}
