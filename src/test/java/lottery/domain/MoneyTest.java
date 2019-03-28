package lottery.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 로또구입() {
        int result = new Money(1000, 0).randomCount();
        assertThat(result).isEqualTo(1);

        Money moneyResult = new Money(2000, 1);
        assertThat(moneyResult.manualCount()).isEqualTo(1);;
        assertThat(moneyResult.randomCount()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 오백원테스트() {
       new Money(500, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 낸돈보다_수동_많이구입_테스트() {
        new Money(1000, 2);
        System.out.println(new Money(1000, 2).toString());
    }
}