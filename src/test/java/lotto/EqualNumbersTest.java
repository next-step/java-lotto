package lotto;

import lotto.domain.*;
import lotto.domain.BuyLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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

        String winOfLottoNumbersText = "15,2,3,18,44,33";

        Set<Integer> winOfLottoNumbers;

        winOfLottoNumbers = Stream.of(winOfLottoNumbersText.split(",")).collect(Collectors.toSet())
                .stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toSet());

        int bonus = 16;

        WinOfLotto winOfLotto = new WinOfLotto(winOfLottoNumbers, bonus);

        TotalEqualNumbers totalEqualNumbers = new TotalEqualNumbers(buyLotto, winOfLotto);

        assertThat(EqualNumbersMoney.EQUALS_3.toString()).isEqualTo("3개 일치 (5000원) - 0개");
        assertThat(EqualNumbersMoney.EQUALS_4.toString()).isEqualTo("4개 일치 (50000원) - 0개");
        assertThat(EqualNumbersMoney.EQUALS_5.toString()).isEqualTo("5개 일치 (1500000원) - 0개");
        assertThat(EqualNumbersMoney.EQUALS_5_BONUS.toString()).isEqualTo("5개 일치 (3000000원) - 1개");
        assertThat(EqualNumbersMoney.EQUALS_6.toString()).isEqualTo("6개 일치 (20000000원) - 0개");
    }
}