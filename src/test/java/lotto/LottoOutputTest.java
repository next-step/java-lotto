package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.BuyLotto;
import lotto.view.LottoOutput;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class LottoOutputTest {

    @Test
    void displayBuyLottoNumbers() {
        LottoOutput lottoOutput = new LottoOutput();

        BuyLotto buyLotto = new BuyLotto(new Money(1000));

        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Lotto lotto = new Lotto(numbers);

        buyLotto.putLottos(lotto);


        Set<Integer> numbers2 = new HashSet<>();
        numbers2.add(5);
        numbers2.add(6);
        numbers2.add(7);
        numbers2.add(8);
        numbers2.add(9);
        numbers2.add(10);

        Lotto lotto2 = new Lotto(numbers2);

        buyLotto.putLottos(lotto2);

//        System.out.println(buyLotto.getLottos().getLottos().toString());

        lottoOutput.displayBuyLottoNumbers(buyLotto);
    }
}