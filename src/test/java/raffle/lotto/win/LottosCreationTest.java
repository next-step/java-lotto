package raffle.lotto.win;

import org.junit.Test;
import raffle.lotto.money.Money;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosCreationTest {

    @Test
    public void 로또수동생성(){
        Money money = new Money(3, 13000);

        LottosCreation lottosCreation = new LottosCreation();
        assertThat(lottosCreation.generate(money)).hasSize(10);

    }
}