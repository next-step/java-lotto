package raffle.lotto.win;

import org.junit.Test;
import raffle.lotto.Lotto;
import raffle.lotto.LottoNo;
import raffle.lotto.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosCreationTest {

    @Test
    public void 로또수동생성(){
        String lottoNo = "1, 6 , 14 , 44 , 36 , 11";
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::new).collect(Collectors.toList())));
        Money money = new Money(1, 0);

        LottosCreation lottosCreation = new LottosCreation(lottos);
        assertThat(lottosCreation.generate(money)).hasSize(1);

    }
}