package lotto.domian;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.common.MessageSet.NOT_ENOUGH_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    @DisplayName("생성자로 입력 받은 금액으로 초기화하여 인스턴스 생성")
    public void create(){
        PurchaseAmount amount = PurchaseAmount.of(13000);
        assertThat(amount.getPurchaseAmount()).isEqualTo(13000);
    }

    @Test
    @DisplayName("구입금액은 천원보다 작을 수 없다.")
    public void giveMoney() throws Exception{
        assertThatThrownBy(()->{
            PurchaseAmount.of(500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ENOUGH_MONEY.getErrorMessage());;
    }

    @Test
    @DisplayName("수익률을 계산한다 - 5000원 투자 50000원 당첨시 수익률은 900프로")
    public void create3() {
        PurchaseAmount amount = PurchaseAmount.of(5000);
        assertThat(amount.calculateTotalProfitRate(50000)).isEqualTo(900.0f);
    }

    @Test
    @DisplayName("수익률을 계산한다 - 5000원 투자 5000원 당첨시 수익률은 0프로")
    public void create4() {
        PurchaseAmount amount = PurchaseAmount.of(5000);
        assertThat(amount.calculateTotalProfitRate(5000)).isEqualTo(0.0f);
    }
}
