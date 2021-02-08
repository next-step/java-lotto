package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.domain.*;
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
        Lotto playersLotto = LottoFactory.createLotto(Arrays.asList(1,2,3,4,5,6));
        List<Lotto> playersLottoTickets = new ArrayList<>(Arrays.asList(
            playersLotto
        ));
        LottoTickets lottoTickets = LottoTickets.of(playersLottoTickets);
        WinnerLotto winnerLotto = WinnerLotto.of(LottoNumber.of(6), LottoFactory.createLotto(Arrays.asList(1,2,3,4,5,6)));
        lottoMatcher.checkAllTickets(lottoTickets, winnerLotto);
        OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
    }
}