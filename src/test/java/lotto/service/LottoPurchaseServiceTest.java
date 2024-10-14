package lotto.service;

import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("1000원 미만 입력 시 예외 발생")
    void 로또_구매_불가_1000원_미만(){
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        Assertions.assertThatThrownBy(
                () -> lottoPurchaseService.calculateNumberOfLotto(999)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
