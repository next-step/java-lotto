package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatcherTest {

    private LottoMatcher lottoMatcher;

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher();
    }

    @DisplayName(value = "로또 티켓의 번호를 입력하면 일치 번호 개수를 출력한다.")
    @Test
    void getLottoTicketCount() {

        Lotto lotto = LottoFactory.createLotto(Arrays.asList(1,3,5,12,14,35));
        WinnerLotto winnerLotto = WinnerLotto.of(LottoNumber.of(7), LottoFactory.createLotto(Arrays.asList(1,2,3,4,5,6)));
        assertThat(winnerLotto.getWinnersLotto().getMatchedCount(lotto)).isEqualTo(3);
    }

    @Test
    void getPrizeBoard() {
    }

    @DisplayName("addPrizeTest")
    @Test
    void addPrizeStatus() {
        Prize prize = Prize.THREE;
        lottoMatcher.addPrizeStatus(prize);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.THREE)).isEqualTo(1);
    }


    @DisplayName("로또 티켓에 대한 등수 매칭 검증. 3개와 6개가 적중한 로또티켓에 대해 테스트.")
    @Test
    void checkAllTickets() {
        List<Integer> firstLotto = Arrays.asList(1,2,3,4,5,6);
        List<Integer> secondLotto = Arrays.asList(1,2,3,9,10,11);
        Lotto playersLotto1 = (LottoFactory.createLotto(firstLotto));
        Lotto playersLotto2 = (LottoFactory.createLotto(secondLotto));

        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(playersLotto1,playersLotto2));
        WinnerLotto winnerLotto = WinnerLotto.of(LottoNumber.of(7), LottoFactory.createLotto(firstLotto));
        lottoMatcher.checkAllTickets(lottoTickets, winnerLotto);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.THREE)).isEqualTo(1);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.SIX)).isEqualTo(1);
    }

    @DisplayName("로또 티켓에 대한 등수 매칭 검증. 5개의 매칭과 보너스 볼을 적중한 로또티켓 테스트.")
    @Test
    void checkFiveWithBonusTicket() {
        List<Integer> firstLotto = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningLotto = Arrays.asList(1,2,3,4,5,11);
        LottoTickets lottoTickets = LottoTickets.of(
                Arrays.asList(
                LottoFactory.createLotto(firstLotto)
                )
        );
        WinnerLotto winnerLotto = WinnerLotto.of(LottoNumber.of(6), LottoFactory.createLotto(winningLotto));
        lottoMatcher.checkAllTickets(lottoTickets, winnerLotto);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.FIVE_WITH_BONUS)).isEqualTo(1);
    }
}