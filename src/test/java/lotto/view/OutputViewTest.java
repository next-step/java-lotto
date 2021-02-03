package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.PlayersLotto;
import lotto.domain.WinnerLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private LottoMatcher lottoMatcher;

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher();
    }

    @Test
    void printWinningResultTest() {
        PlayersLotto playersLotto1 = new PlayersLotto(Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        List<PlayersLotto> playersLottos = new ArrayList<>(Arrays.asList(
            playersLotto1
        ));
        LottoTickets lottoTickets = new LottoTickets(playersLottos);
        List<LottoNumber> winnerNumbers = new ArrayList<>();
        winnerNumbers.add(new LottoNumber(1));
        winnerNumbers.add(new LottoNumber(2));
        winnerNumbers.add(new LottoNumber(3));
        winnerNumbers.add(new LottoNumber(4));
        winnerNumbers.add(new LottoNumber(5));
        winnerNumbers.add(new LottoNumber(7));
        WinnerLotto winnerLotto = new WinnerLotto(new LottoNumber(6), winnerNumbers);
        lottoMatcher.checkAllTickets(lottoTickets, winnerLotto);
        OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
    }
}