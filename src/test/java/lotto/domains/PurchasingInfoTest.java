package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasingInfoTest {
    @Test
    void 생성자_테스트() {
        PurchasingInfo purchasingInfo = new PurchasingInfo(2000, Arrays.asList("1,2,3,4,5,6"));
        assertThat(purchasingInfo).isNotNull();
    }

    @Test
    void 자동로또갯수_반환_테스트() {
        PurchasingInfo purchasingInfo = new PurchasingInfo(3000, Arrays.asList("1,2,3,4,5,6"));
        assertThat(purchasingInfo.autoLottoCount()).isEqualTo(2);
    }

    @Test
    void 수동로또갯수_반환_테스트() {
        PurchasingInfo purchasingInfo = new PurchasingInfo(3000, Arrays.asList("1,2,3,4,5,6"));
        assertThat(purchasingInfo.manualLottoCount()).isEqualTo(1);
    }

}
