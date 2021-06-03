package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ManualPurchaseInformationTest {

    @DisplayName("수동 구매 정보는 몇장을 구매할 수 있는지 알 수있다.")
    @Test
    void manual_putchase_information_lotto_count() {
        //given
        final int allLottoCount = 10;
        final int manualCount = 7;
        final PurchaseInformation manualPurchaseInformation = new ManualPurchaseInformation(allLottoCount, manualCount);
        final int expected = 7;

        //when
        final int lottoCount = manualPurchaseInformation.getLottoCount();

        //then
        assertThat(lottoCount).isEqualTo(expected);
    }


    @DisplayName("수동 구매 정보는 전체 구매 갯수보다 클 수 없다.")
    @Test
    void manual_putchase_information_over_lotto_count() {
        //given
        final int allLottoCount = 10;
        final int manualCount = 11;

        //when,then
        assertThatIllegalArgumentException().isThrownBy(() -> new ManualPurchaseInformation(allLottoCount, manualCount))
                .withMessageMatching(ManualPurchaseInformation.MANUAL_LOTTO_COUNT_OVER_MESSAGE);
    }
}