package step2.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import step2.model.Money;

public class MoneyTest {
    @Test
    public void 금액에_따른_로또_장수_테스트() {
        assertThat(new Money(4500).determineLottoPurchaseCount()).isEqualTo(4);
    }

    @Test
    public void 금액보다_수동로또금액이_클_경우_테스트() {
        assertThatThrownBy(() -> new Money(5000).purchaseManualLotto(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 금액보다_수동로또금액이_구매_후_잔액_테스트() {
        assertThat(new Money(5000).purchaseManualLotto(3)).isEqualTo(new Money(2000));
    }
}
