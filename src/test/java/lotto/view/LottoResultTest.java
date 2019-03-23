package lotto.view;

import lotto.domain.LottoStore;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Ticket;
import lotto.domain.lotto.WinningLotto;
import lotto.utils.ManualLottoGenerator;
import lotto.utils.TestRandomLottoGenerator;
import lotto.view.vo.MatchResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 열개_모두_5등일경우_수익률_5배() {
        int money = 10000;
        int manualCount = 3;
        List<Ticket> manualLottoNumbers = new ArrayList<>();
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);

        LottoStore lottoStore = new LottoStore(new ManualLottoGenerator(), new TestRandomLottoGenerator(), money, manualLottoNumbers);
        LottoBundle lottoBundle = lottoStore.buyManualLottos(manualLottoNumbers);
        lottoBundle.addAll(lottoStore.buyRandomLottos());

        Ticket winningLottoTicket = new Ticket(1, 2, 3, 7, 8, 9);

        WinningLotto winningLotto = new WinningLotto(winningLottoTicket, new LottoNumber(20));
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottoBundle);

        LottoResult lottoResult = new LottoResult(winningLotto);
        lottoResult.generate(lottoBundle);

        assertThat(lottoResult.getRewardPercent(money)).isEqualTo(5.0);
    }
}
