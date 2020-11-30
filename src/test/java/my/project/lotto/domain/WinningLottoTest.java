package my.project.lotto.domain;

import my.project.lotto.domain.Rank;
import my.project.lotto.dto.LottoNumber;
import my.project.lotto.dto.Lottos;
import my.project.lotto.dto.ManualLottos;
import my.project.lotto.dto.Ranks;
import my.project.lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @Test
    void testCountRanks() {
        Money money = new Money(14000);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(lottoNumbers));
        ManualLottos manualLottos = new ManualLottos(lottoList);
        Lottos lottos = Lottos.lotto(money, manualLottos);

        List<LottoNumber> lastWinningNumber = new ArrayList<>();
        lastWinningNumber.add(new LottoNumber(1));
        lastWinningNumber.add(new LottoNumber(2));
        lastWinningNumber.add(new LottoNumber(3));
        lastWinningNumber.add(new LottoNumber(4));
        lastWinningNumber.add(new LottoNumber(5));
        lastWinningNumber.add(new LottoNumber(6));
        Lotto lastWinningLotto = new Lotto(lastWinningNumber);
        WinningLotto winningLotto = new WinningLotto(lottos, lastWinningLotto, new LottoNumber(45));

        assertThat(winningLotto.countFirstRanks()).isEqualTo(1);
    }

    @Test
    void testCountTwiceRanks() {
        Money money = new Money(14000);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(lottoNumbers));

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        lottoNumbers2.add(new LottoNumber(1));
        lottoNumbers2.add(new LottoNumber(2));
        lottoNumbers2.add(new LottoNumber(3));
        lottoNumbers2.add(new LottoNumber(4));
        lottoNumbers2.add(new LottoNumber(5));
        lottoNumbers2.add(new LottoNumber(6));
        lottoList.add(new Lotto(lottoNumbers2));

        ManualLottos manualLottos = new ManualLottos(lottoList);
        Lottos lottos = Lottos.lotto(money, manualLottos);

        List<LottoNumber> lastWinningNumber = new ArrayList<>();
        lastWinningNumber.add(new LottoNumber(1));
        lastWinningNumber.add(new LottoNumber(2));
        lastWinningNumber.add(new LottoNumber(3));
        lastWinningNumber.add(new LottoNumber(4));
        lastWinningNumber.add(new LottoNumber(5));
        lastWinningNumber.add(new LottoNumber(6));
        Lotto lastWinningLotto = new Lotto(lastWinningNumber);
        WinningLotto winningLotto = new WinningLotto(lottos, lastWinningLotto, new LottoNumber(45));

        assertThat(winningLotto.countFirstRanks()).isEqualTo(2);
    }

    @Test
    void testProfit() {
        Money money = new Money(14000);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(lottoNumbers));
        ManualLottos manualLottos = new ManualLottos(lottoList);
        Lottos lottos = Lottos.lotto(money, manualLottos);

        List<LottoNumber> lastWinningNumber = new ArrayList<>();
        lastWinningNumber.add(new LottoNumber(1));
        lastWinningNumber.add(new LottoNumber(2));
        lastWinningNumber.add(new LottoNumber(3));
        lastWinningNumber.add(new LottoNumber(4));
        lastWinningNumber.add(new LottoNumber(5));
        lastWinningNumber.add(new LottoNumber(6));
        Lotto lastWinningLotto = new Lotto(lastWinningNumber);
        WinningLotto winningLotto = new WinningLotto(lottos, lastWinningLotto, new LottoNumber(45));

        assertThat(winningLotto.profit()).isEqualTo("142857.14");
    }
}