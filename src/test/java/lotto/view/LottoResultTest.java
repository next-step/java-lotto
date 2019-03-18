package lotto.view;

import lotto.domain.LottoStore;
import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.utils.TestLottoGenerator;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 열개_모두_5등일경우_수익률_5배() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoStore lottoStore = new LottoStore(new TestLottoGenerator());

        List<BasicLotto> lottos = lottoStore.buyLottos(money);

        scanner = new Scanner("1, 3, 5, 8, 9, 10");
        List<Integer> winningLottoNumbers
            = InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.", ",", scanner);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        LottoResult.generate(lottos, winningLotto);

        assertThat(LottoResult.getRewardPercent(money)).isEqualTo("5.00");
    }
}
