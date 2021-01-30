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
        List<LottoNumber> lottoNumber = new ArrayList<>();
        lottoNumber.add(new LottoNumber(1));
        lottoNumber.add(new LottoNumber(3));
        lottoNumber.add(new LottoNumber(5));
        lottoNumber.add(new LottoNumber(14));
        lottoNumber.add(new LottoNumber(22));
        lottoNumber.add(new LottoNumber(45));

        List<LottoNumber> winnerNumbers = new ArrayList<>();
        winnerNumbers.add(new LottoNumber(1));
        winnerNumbers.add(new LottoNumber(2));
        winnerNumbers.add(new LottoNumber(3));
        winnerNumbers.add(new LottoNumber(4));
        winnerNumbers.add(new LottoNumber(5));
        winnerNumbers.add(new LottoNumber(6));

        WinnerLotto winnerLotto = new WinnerLotto(new LottoNumber(7), winnerNumbers);
        assertThat(LottoMatcher.getMatchCnt(lottoNumber, winnerLotto)).isEqualTo(3);
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

    //TODO: 이부분에서 개수로만 Enum 매핑을 테스트 하도록 하면 보너스 넘버에 대한 논리 구조가 안맞는것 같다는 생각이 들어요!
    // 그래서 의견을 듣고자 코멘트로 남겼습니다
    // choi: 해당 메소드의 인풋이 지금처럼 LottoList고 내부에서 getMatchCnt 를 호출하는 형태면 되겠네요
//    @DisplayName("맞춘 개수에 따른 상 enum 반환")
//    @Test
//    void getPrizeForEachLotto() {
//        int matchedCount = 6;
//
//        assertThat(lottoMatcher.getPrizeForEachLotto(matchedCount, new LottoNumber(6))).isEqualTo(Prize.SIX);
//    }

    @DisplayName("로또 티켓에 대한 등수 매칭 검증. 3개와 6개가 적중한 로또티켓에 대해 테스트.")
    @Test
    void checkAllTickets() {

        PlayersLotto playersLotto1 = new PlayersLotto(Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        ));
        PlayersLotto playersLotto2 = new PlayersLotto(Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(9),
            new LottoNumber(10),
            new LottoNumber(11)
        ));
        List<PlayersLotto> playersLottos = new ArrayList<>(Arrays.asList(
            playersLotto1,
            playersLotto2
        ));
        LottoTickets lottoTickets = new LottoTickets(playersLottos);
        List<LottoNumber> winnerNumbers = new ArrayList<>();
        winnerNumbers.add(new LottoNumber(1));
        winnerNumbers.add(new LottoNumber(2));
        winnerNumbers.add(new LottoNumber(3));
        winnerNumbers.add(new LottoNumber(4));
        winnerNumbers.add(new LottoNumber(5));
        winnerNumbers.add(new LottoNumber(6));
        WinnerLotto winnerLotto = new WinnerLotto(new LottoNumber(7), winnerNumbers);
        lottoMatcher.checkAllTickets(lottoTickets, winnerLotto);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.THREE)).isEqualTo(1);
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.SIX)).isEqualTo(1);
    }

    @DisplayName("로또 티켓에 대한 등수 매칭 검증. 5개의 매칭과 보너스 볼을 적중한 로또티켓 테스트.")
    @Test
    void checkFiveWithBonusTicket() {
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
        assertThat(lottoMatcher.getPrizeBoard().get(Prize.FIVE_WITH_BONUS)).isEqualTo(1);
    }
}