package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step2.model.Money;

public class MoneyTest {
    @Test
    public void 금액에_따른_로또_장수_테스트() {
        assertThat(new Money(4500).determineLottoPurchaseCount()).isEqualTo(4);
    }
}
