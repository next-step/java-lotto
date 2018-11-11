package raffle.lotto.win;

import org.junit.Test;
import raffle.lotto.Lotto;
import raffle.lotto.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosCreationTest {

    @Test
    public void 로또수동생성(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 6, 5, 44, 22, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 5, 44, 22, 15)));
        lottos.add(new Lotto(Arrays.asList(1, 6, 30, 44, 32, 15)));
        Money money = new Money(3, 0);

        LottosCreation lottosCreation = new LottosCreation(lottos);
        assertThat(lottosCreation.generate(money)).hasSize(3);

    }
}