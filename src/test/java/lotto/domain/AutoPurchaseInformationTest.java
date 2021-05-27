package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoPurchaseInformationTest {

    @DisplayName("자동 구매 정보는 몇장을 구매할 수 있는지 알 수있다.")
    @Test
    void auto_putchase_information_lotto_count() {
        //given
        final int allLottoCount = 10;
        final int manualCount = 3;
        final PurchaseInformation autoPurchaseInformation = new AutoPurchaseInformation(allLottoCount, manualCount);
        final int expected = 7;

        //when
        final int lottoCount = autoPurchaseInformation.getLottoCount();

        //then
        assertThat(lottoCount).isEqualTo(expected);
    }
}