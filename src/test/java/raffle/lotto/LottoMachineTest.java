package raffle.lotto;

import org.junit.Test;
import raffle.lotto.money.Money;
import raffle.lotto.validator.LottoNumberValidator;
import raffle.lotto.win.LottosCreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 로또입력확인() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 6, 5, 44, 22, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 5, 44, 22, 15)));
        lottos.add(new Lotto(Arrays.asList(1, 6, 30, 44, 32, 15)));

        Money money = new Money(3 , 13000);

        LottoMachine lottoMachine = new LottoMachine(money, new LottoNumberValidator(), new LottosCreation(lottos));
        assertThat(lottoMachine.getLottos()).hasSize(13);
    }

}