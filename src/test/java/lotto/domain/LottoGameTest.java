package lotto.domain;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.utils.RandomLottoGenerator;
import lotto.utils.TestLottoGenerator;
import lotto.view.InputView;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void 구입금액_음수입력시_예외() {
        Scanner scanner = new Scanner("-1000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoGame lottoGame = new LottoGame(new RandomLottoGenerator());
        lottoGame.createLottos(money);
    }

    @Test
    public void 횟수만큼_로또_생성() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoGame lottoGame = new LottoGame(new RandomLottoGenerator());

        assertThat(lottoGame.createLottos(money).size()).isEqualTo(10);
    }

    @Test
    public void 테스트전용_로또생성기로_로또생성() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoGame lottoGame = new LottoGame(new TestLottoGenerator());

        BasicLotto firstLotto = lottoGame.createLottos(money).get(0);

        assertThat(firstLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또_매치카운트업_테스트_3개_맞음() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoGame lottoGame = new LottoGame(new TestLottoGenerator());

        List<BasicLotto> lottos = lottoGame.createLottos(money);

        scanner = new Scanner("1, 3, 5, 8, 9, 10");
        List<Integer> winningLottoNumbers
            = InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.", ",", scanner);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        lottoGame.play(lottos, winningLotto);

        assertThat(lottos.get(0).getMatchCount()).isEqualTo(3);
    }

    @Test
    public void 로또_매치카운트업_테스트_6개_맞음() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoGame lottoGame = new LottoGame(new TestLottoGenerator());

        List<BasicLotto> lottos = lottoGame.createLottos(money);

        scanner = new Scanner("1, 2, 3, 4, 5, 6");
        List<Integer> winningLottoNumbers
            = InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.", ",", scanner);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        lottoGame.play(lottos, winningLotto);

        assertThat(lottos.get(0).getMatchCount()).isEqualTo(6);
    }
}
