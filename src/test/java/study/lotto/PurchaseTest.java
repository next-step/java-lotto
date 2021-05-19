package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    @DisplayName("입력한 금액만큼 로또 구매")
    @Test
    public void buyTest(){
        //given
        BigDecimal paymentAmount = BigDecimal.valueOf(14000);

        LottoQuantity result = LottoQuantity.purchase(paymentAmount);
        assertThat(result.getLottoQuantity()).isEqualTo(14);
    }


}
