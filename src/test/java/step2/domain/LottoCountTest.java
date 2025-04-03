package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.lotto.*;

class LottoCountTest {

    @DisplayName("로또 구입 금액이 로또 1개 가격 단위가 아니거나 1개 가격 이하인 경우 IllegalArgumentException throw")
    @CsvSource(value={"0, 500", "500, 1000", "1500, 1000"})
    @ParameterizedTest
    void shouldNotAllowInvalidLottoPurchaseAmount(int purchaseAmount, int lottoPrice) {
        Assertions.assertThatThrownBy(() -> new LottoCount(purchaseAmount, lottoPrice, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("해당하는 갯수만큼의 로또 생성")
    @Test
    void generateLottoTest() {
        // given
        int purchaseAmount = 14000;
        int lottoPrice = 1000;
        int manualLottoCount = 7;
        LottoCount lottoCount = new LottoCount(purchaseAmount, lottoPrice, manualLottoCount);

        // when
        LottoGenerator lottoGenerator = new LottoGenerator(1, 45, 6);
        LottoContainer lottoContainer = lottoCount.generateAutoLottoContainer(lottoGenerator);

        // then
        int totalLottoCount = purchaseAmount / lottoPrice;
        Assertions.assertThat(lottoContainer.size()).isEqualTo(totalLottoCount - manualLottoCount);
    }

    @DisplayName("수익률 계산 테스트")
    @CsvSource({"1000, 1000", "2000, 500", "4000, 3000"})
    @ParameterizedTest
    void getWinningRate(int purchasedAmount, int winningAmount) {
        // given
        LottoCount lottoCount = new LottoCount(purchasedAmount, 1000, 0);

        // when
        double winningRate = lottoCount.getWinningRate(winningAmount);

        // then
        double actual = (double) winningAmount / purchasedAmount;
        Assertions.assertThat(actual).isEqualTo(winningRate);
    }
}