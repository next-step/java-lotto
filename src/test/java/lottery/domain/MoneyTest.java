package lottery.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 로또한장구입() {
        int result = new Money(1000).purchaseCount();
        assertThat(result).isEqualTo(1);

        result = new Money(2000).purchaseCount();
        assertThat(result).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 오백원테스트() {
       new Money(500);
    }
}