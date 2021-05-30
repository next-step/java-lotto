package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasingInfoTest {
    @Test
    void 생성자_테스트() {
        PurchasingInfo purchasingInfo = new PurchasingInfo(2000, 1, Arrays.asList("1,2,3,4,5,6"));
        assertThat(purchasingInfo).isNotNull();
    }

    @Test
    void 수동로또_개수_음수_에러_테스트() {
        assertThatThrownBy(() -> new PurchasingInfo(1000, -1, Arrays.asList("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 투입금액보다_많은_수동로또_구매_에러_테스트() {
        assertThatThrownBy(() -> new PurchasingInfo(1000, 2, Arrays.asList("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동로또갯수_반환_테스트() {
        PurchasingInfo purchasingInfo = new PurchasingInfo(3000, 1, Arrays.asList("1,2,3,4,5,6"));
        assertThat(purchasingInfo.autoLottoCount()).isEqualTo(2);
    }

    @Test
    void 수동로또갯수_반환_테스트() {
        PurchasingInfo purchasingInfo = new PurchasingInfo(3000, 1, Arrays.asList("1,2,3,4,5,6"));
        assertThat(purchasingInfo.manualLottoCount()).isEqualTo(1);
    }

}
