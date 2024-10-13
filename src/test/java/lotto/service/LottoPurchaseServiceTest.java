package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseServiceTest {

    @Test
    @DisplayName("로또 개수 구하기(1000원 이상)")
    void 로또_개수_구하기_1000원_이상(){

        LottoPurchaseService lotto = new LottoPurchaseService();

        assertThat(lotto.calculateNumberOfLotto(14000)).isEqualTo(14);

    }

}
