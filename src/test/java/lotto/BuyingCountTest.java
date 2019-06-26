package lotto;

import lotto.domain.BuyingCount;
import lotto.domain.BuyingLottos;
import lotto.view.data.LottoBuyingInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyingCountTest {
    @Test
    @DisplayName("입력한 금액만큼 수동구매가 불가능하다.")
    void canBuyingSelfLottoFailTest() {
        //Given
        LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo(5000, 6);
        //When
        BuyingCount buyingCount = new BuyingCount(lottoBuyingInfo.getCashPayment(), lottoBuyingInfo.getSelfCount());
        boolean canBuyingSelfLotto = BuyingLottos.canBuyingSelfLotto(lottoBuyingInfo.getCashPayment(), lottoBuyingInfo.getSelfCount());
        //Then
        Assertions.assertThat(canBuyingSelfLotto).isFalse();
    }
}
