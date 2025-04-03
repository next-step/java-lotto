package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.lotto.*;

class LottoPurchaseManagerTest {

    @DisplayName("로또 구입 금액이 로또 1개 가격 단위가 아니거나 1개 가격 이하인 경우 IllegalArgumentException throw")
    @CsvSource(value={"0, 500", "500, 1000", "1500, 1000"})
    @ParameterizedTest
    void shouldNotAllowInvalidLottoPurchaseAmount(int inputAmount, int lottoPrice) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        Assertions.assertThatThrownBy(() -> new LottoPurchaseManager(purchaseAmount, lottoPrice, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("해당하는 갯수만큼의 로또 생성")
    @Test
    void generateLottoTest() {
        // given
        int inputAmount = 14000;
        int lottoPrice = 1000;
        int manualLottoCount = 7;

        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(purchaseAmount, lottoPrice, manualLottoCount);

        // when
        LottoGenerator lottoGenerator = new LottoGenerator(1, 45, 6);
        LottoContainer lottoContainer = lottoPurchaseManager.generateAutoLottoContainer(lottoGenerator);

        // then
        int totalLottoCount = inputAmount / lottoPrice;
        Assertions.assertThat(lottoContainer.size()).isEqualTo(totalLottoCount - manualLottoCount);
    }
}