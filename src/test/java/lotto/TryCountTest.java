package lotto;

import lotto.domain.TryCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {


    public static final int TRY_COUNT = 5;
    public static final int PURCHASE_AMOUNT = 5000;

    @Test
    void 금액_개수변환테스트() {
        final int PURCHASE_AMOUNT = 5000;
        final int TRY_COUNT = 5;

        TryCount tryCount = TryCount.initTryCount(PURCHASE_AMOUNT);
        assertThat(tryCount).isEqualTo(new TryCount(TRY_COUNT));
    }

    @Test
    @DisplayName(value = "수동로또회수가 전체 회수 초과시 실패")
    void checkManualTryTest() {
        final int MANUAL_TRY = 6;

        TryCount tryCount = TryCount.initTryCount(PURCHASE_AMOUNT);
        assertThatThrownBy(() -> {
            tryCount.validateManualTry(TRY_COUNT, MANUAL_TRY);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(value = "수동로또회수만큼 자동로또개수에서 뺀값으로 자동로또개수 업데이트")
    void updateManualTryTest() {
        final int MANUAL_TRY = 3;
        final int UPDATED_TRYCOUNT = 2;

        int updatedTryCount = TryCount.updateWithManualTry(TRY_COUNT, MANUAL_TRY);
        assertThat(updatedTryCount).isEqualTo(UPDATED_TRYCOUNT);
    }


}