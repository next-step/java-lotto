package lotto.view.vo;

import lotto.domain.LottoStore;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Ticket;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.utils.ManualLottoGenerator;
import lotto.utils.TestRandomLottoGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MatchResultTest {

    @Test
    public void 로또_매칭_결과_저장_테스트() {
        int money = 10000;
        int manualCount = 3;
        List<Ticket> manualLottoNumbers = new ArrayList<>();
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);

        LottoStore lottoStore = new LottoStore(new ManualLottoGenerator(), new TestRandomLottoGenerator(), money, manualLottoNumbers);
        LottoBundle lottos = lottoStore.buyManualLottos(manualLottoNumbers);
        lottos.addAll(lottoStore.buyRandomLottos());

        Ticket winningLottoTicket = new Ticket(1, 2, 3, 4, 5, 7);

        WinningLotto winningLotto = new WinningLotto(winningLottoTicket, new LottoNumber(6));
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottos);

        assertThat(matchResult.getCountInfo().getCounts().get(Rank.SECOND)).isEqualTo(10);
    }

    @Test
    public void 매칭_결과를_바탕으로_수익률_계산() {
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

        Ticket winningLottoTicket = new Ticket(1, 2, 3, 4, 5, 7);

        WinningLotto winningLotto = new WinningLotto(winningLottoTicket, new LottoNumber(6));
        MatchResult matchResult = new MatchResult(winningLotto);

        matchResult.calculate(lottoBundle);

        assertThat(matchResult.calculateTotalReward()).isEqualTo(300_000_000L);
    }
}
