package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoCountTest {

    private PurchaseAmount purchaseAmount = PurchaseAmount.newInstance(5000);

    @DisplayName("구입금액이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateManualLottoCountIfPurchaseAmountIsNull() {
        assertThatThrownBy(() -> ManualLottoCount.newInstance(0, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 수가 0 보다 작으면 생성할 수 없다.")
    @Test
    void canNotCreateManualLottoCountIfLottoCountLessThen0() {
        assertThatThrownBy(() -> ManualLottoCount.newInstance(-1, this.purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 수가 총 구입 수를 초과하면 생성할 수 없다.")
    @Test
    void canNotCreateManualLottoCountIfLottoCountGreaterThanTotalPurchaseCount() {
        assertThatThrownBy(() -> ManualLottoCount.newInstance(6, this.purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 수를 생성할 수 있다.")
    @Test
    void canCreateManualLottoCount() {
        assertThat(ManualLottoCount.newInstance(1, this.purchaseAmount)).isInstanceOf(ManualLottoCount.class);
    }

    @DisplayName("수동 로또 수를 얻을 수 있다.")
    @Test
    void canGetManualLottoCount() {
        int lottoCount = 3;
        ManualLottoCount manualLottoCount = ManualLottoCount.newInstance(lottoCount, this.purchaseAmount);

        assertThat(manualLottoCount.getManualLottoCount()).isEqualTo(lottoCount);
    }

    @DisplayName("내부 로또 수가 같으면 동일한 객체이다.")
    @Test
    void canSameManualLottoCountIfLottoCountSame() {
        int lottoCount = 3;
        ManualLottoCount manualLottoCount1 = ManualLottoCount.newInstance(lottoCount, this.purchaseAmount);
        ManualLottoCount manualLottoCount2 = ManualLottoCount.newInstance(lottoCount, this.purchaseAmount);

        assertThat(manualLottoCount1.getManualLottoCount()).isEqualTo(manualLottoCount2.getManualLottoCount());
        assertThat(manualLottoCount1).isEqualTo(manualLottoCount2);
        assertThat(manualLottoCount1.hashCode()).isEqualTo(manualLottoCount2.hashCode());
    }
}
