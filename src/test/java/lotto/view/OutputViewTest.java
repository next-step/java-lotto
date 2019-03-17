package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.utils.TestLottoGenerator;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @Test
    public void 열개_모두_5등일경우_수익률_5배() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoGame lottoGame = new LottoGame(new TestLottoGenerator());

        List<BasicLotto> lottos = lottoGame.createLottos(money);

        scanner = new Scanner("1, 3, 5, 8, 9, 10");
        List<Integer> winningLottoNumbers
            = InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.", ",", scanner);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        lottoGame.play(lottos, winningLotto);

        OutputView.generateResult(lottos);

        assertThat(OutputView.getRewardPercent(money)).isEqualTo("5.00");
    }
}
