package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryShopTest {

    @DisplayName("복권가게는 지불한 금액으로 구매할 수 있는 만큼 복권을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "800,0", "1000,1", "3400,3"})
    void purchase(int cash, int expectAmount) {
        assertThat(LotteryShop.purchase(new Cash(cash)).size())
                .isEqualTo(expectAmount);
    }
}
