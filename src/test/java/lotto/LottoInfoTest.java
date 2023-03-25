package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.BuyLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class LottoInfoTest {

    @Test
    void 구입한_로또_번호들_출력() {
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();

        Set<Integer> lottoNumber1 = new HashSet<>();
        Set<Integer> lottoNumber2 = new HashSet<>();

        BuyLotto buyLottos = new BuyLotto(new Money(2000));

        lottoNumber1.add(3);
        lottoNumber1.add(16);
        lottoNumber1.add(2);
        lottoNumber1.add(44);
        lottoNumber1.add(33);
        lottoNumber1.add(18);

        Lotto lotto1 = new Lotto(lottoNumber1);
        buyLottos.putLottos(lotto1);

        lottoNumber2.add(4);
        lottoNumber2.add(8);
        lottoNumber2.add(2);
        lottoNumber2.add(41);
        lottoNumber2.add(23);
        lottoNumber2.add(1);

        Lotto lotto2 = new Lotto(lottoNumber2);
        buyLottos.putLottos(lotto2);

        lottoOutput.displayBuyLottoNumbers(buyLottos);
    }
}