package lotto;

import lotto.domain.*;
import lotto.service.BuyLotto;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class EqualNumbersTest {
    @Test
    void 로또_번호_맞추기() {

        Set<Integer> lottoNumbers = new HashSet<>();

        lottoNumbers.add(3);
        lottoNumbers.add(16);
        lottoNumbers.add(2);
        lottoNumbers.add(44);
        lottoNumbers.add(33);
        lottoNumbers.add(18);

        Lotto lotto = new Lotto(lottoNumbers);

        BuyLotto buyLotto = new BuyLotto(new Money(1000));
        buyLotto.putLottos(lotto);

        Set<Integer> winLotto = new HashSet<>();

        String winOfLottoNumbersText = "15,2,3,18,44,33";

        Set<Integer> winOfLottoNumbers;

        winOfLottoNumbers = Stream.of(winOfLottoNumbersText.split(",")).collect(Collectors.toSet())
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toSet());

        int bonus = 16;

        WinOfLotto winOfLotto = new WinOfLotto(winOfLottoNumbers, bonus);

        TotalEqualNumbers totalEqualNumbers = new TotalEqualNumbers(buyLotto, winOfLotto);

        System.out.println(totalEqualNumbers.getEqualsNumberCount3());
        System.out.println(totalEqualNumbers.getEqualsNumberCount4());
        System.out.println(totalEqualNumbers.getEqualsNumberCount5());
        System.out.println(totalEqualNumbers.getEqualsNumberCountBonus5());
        System.out.println(totalEqualNumbers.getEqualsNumberCount6());
    }

}