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

        List<LottoNumber> lottoNumbers = LottoFactory.createListOfLottoNumber(new int[]{1,3,5,12,14,35});
        List<LottoNumber> winnerNumbers = LottoFactory.createListOfLottoNumber(new int[]{1,2,3,4,5,6});
        Lotto lotto = Lotto.of(lottoNumbers);
        WinnerLotto winnerLotto = WinnerLotto.of(LottoNumber.of(7), winnerNumbers);
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
        int [] firstLotto = {1,2,3,4,5,6};
        int [] secondLotto = {1,2,3,9,10,11};
        Lotto playersLotto1 = Lotto.of(LottoFactory.createListOfLottoNumber(firstLotto));

        Lotto playersLotto2 = Lotto.of(LottoFactory.createListOfLottoNumber(secondLotto));
        List<Lotto> playersLottos = new ArrayList<>(Arrays.asList(
            playersLotto1,
            playersLotto2
        ));
        LottoTickets lottoTickets = LottoTickets.of(playersLottos);
        List<LottoNumber> winnerNumbers = LottoFactory.createListOfLottoNumber(firstLotto);
        WinnerLotto winnerLotto = WinnerLotto.of(LottoNumber.of(7), winnerNumbers);
        lottoMatcher.checkAllTickets(lottoTickets, winnerLotto);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.THREE)).isEqualTo(1);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.SIX)).isEqualTo(1);
    }

    @DisplayName("로또 티켓에 대한 등수 매칭 검증. 5개의 매칭과 보너스 볼을 적중한 로또티켓 테스트.")
    @Test
    void checkFiveWithBonusTicket() {
        int [] playerLotto = {1,2,3,4,5,6};
        int [] winningLotto = {1,2,3,4,5,7};
        List<Lotto> playersLottos = new ArrayList<>(Arrays.asList(
                Lotto.of(LottoFactory.createListOfLottoNumber(playerLotto))
        ));
        LottoTickets lottoTickets = LottoTickets.of(playersLottos);
        List<LottoNumber> winnerNumbers = LottoFactory.createListOfLottoNumber(winningLotto);
        WinnerLotto winnerLotto = WinnerLotto.of(LottoNumber.of(6), winnerNumbers);
        lottoMatcher.checkAllTickets(lottoTickets, winnerLotto);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.FIVE_WITH_BONUS)).isEqualTo(1);
    }
}