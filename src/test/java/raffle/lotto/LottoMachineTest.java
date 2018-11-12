package raffle.lotto;

import org.junit.Test;
import raffle.lotto.money.Money;
import raffle.lotto.validator.LottoNumberValidator;
import raffle.lotto.win.LottosCreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 로또입력확인() {
        String lottoNo = "1, 6 , 14 , 44 , 36 , 11";

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList())));

        Money money = new Money(1 , 13000);

        LottoMachine lottoMachine = new LottoMachine(money, new LottosCreation(lottos));
        assertThat(lottoMachine.getLottos()).hasSize(13);
    }

}