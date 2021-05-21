package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("입력한 금액만큼 구매 가능한 장수를 확인한다")
    @Test
    public void purchaseableLottoTest(){
        //given
        BigDecimal paymentAmount = BigDecimal.valueOf(14000);

        int result = LottoGame.purchaseableLotto(paymentAmount);
        assertThat(result).isEqualTo(14);
    }


}
