package lottoTest;

import lotto.Money;
import lotto.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    @DisplayName("구입한 로또의 수보다 수동 로또 입력 갯수가 높으면 exception")
    void INPUT_MANUAL_MORE_THAN_TOTAL_AMOUNT(){
        Money money = new Money(3000);
        Assertions.assertThatThrownBy(()-> PurchaseAmount.of(money.purchase(), 4))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
