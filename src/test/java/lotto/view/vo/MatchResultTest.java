package lotto.view.vo;

import lotto.domain.LottoStore;
import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.utils.TestLottoGenerator;
import lotto.view.InputView;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MatchResultTest {

    @Test
    public void 로또_매칭_결과_저장_테스트() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoStore lottoStore = new LottoStore(new TestLottoGenerator());

        List<BasicLotto> lottos = lottoStore.buyLottos(money);

        scanner = new Scanner("1, 2, 3, 4, 5, 7");
        List<Integer> winningLottoNumbers
            = InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.", ",", scanner);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 6);
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottos);

        assertThat(matchResult.getRanks().get(Rank.SECOND)).isEqualTo(10);
    }

    @Test
    public void 매칭_결과를_바탕으로_수익률_계산() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoStore lottoStore = new LottoStore(new TestLottoGenerator());

        List<BasicLotto> lottos = lottoStore.buyLottos(money);

        scanner = new Scanner("1, 2, 3, 4, 5, 7");
        List<Integer> winningLottoNumbers
            = InputView.getWinningLottoNumbers("지난 주 당첨 번호를 입력해 주세요.", ",", scanner);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 6);
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottos);

        assertThat(matchResult.calculateTotalReward()).isEqualTo(300_000_000L);
    }
}
