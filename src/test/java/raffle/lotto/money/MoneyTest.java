package raffle.lotto.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 머니_생성_확인(){
        Money money = new Money(3, 13000);

        assertThat(money.getManualCount()).isEqualTo(3);
        assertThat(money.getRancomCount()).isEqualTo(10);
    }

}