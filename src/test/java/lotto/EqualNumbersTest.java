package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinOfLotto;
import lotto.domain.EqualNumbers;
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

        BuyLotto buyLotto = new BuyLotto(1000);
        buyLotto.putLottos(lotto);

        Set<Integer> winLotto = new HashSet<>();

        String winOfLottoNumbersText = "15,2,3,18,44,33";

        Set<Integer> winOfLottoNumbers;

        winOfLottoNumbers = Stream.of(winOfLottoNumbersText.split(",")).collect(Collectors.toSet())
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toSet());
//                Stream.of()).collect(Collectors.toSet());




//        winLotto.add(15);
//        winLotto.add(2);
//        winLotto.add(18);
//        winLotto.add(3);
//        winLotto.add(44);
//        winLotto.add(33);

        int bonus = 16;

        WinOfLotto winOfLotto = new WinOfLotto(winOfLottoNumbers, bonus);

        EqualNumbers equalNumbers = new EqualNumbers(buyLotto, winOfLotto);

        System.out.println(equalNumbers.getEqual3());
        System.out.println(equalNumbers.getEqual4());
        System.out.println(equalNumbers.getEqual5());
        System.out.println(equalNumbers.getEqual5_bonus());
        System.out.println(equalNumbers.getEqual6());
    }

}