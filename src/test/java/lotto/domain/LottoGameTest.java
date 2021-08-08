package lotto.domain;

import lotto.strategy.ListSortStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    public static final int TICKET_NUMBER = 5;
    private LottoGame lottoGame = new LottoGame();
    private List<LottoNumber> winnerNumbers = new ArrayList<>();
    private LottoNumbers winnerLottoNumbers;

    @BeforeEach
    void setUp() {
        IntStream.range(1, 7).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
        winnerLottoNumbers = new LottoNumbers(winnerNumbers);
    }

    @Test
    @DisplayName("정렬된 전략으로 로또 티켓을 구입 시 각 로또가 1,2,3,4,5,6 을 포함한다.")
    void purchase() {
        lottoGame.purchase(TICKET_NUMBER, new ListSortStrategy());
        assertEquals(lottoGame.getLottos().getLottos().size(), TICKET_NUMBER);
        IntStream.range(0, TICKET_NUMBER).forEach(index ->
        assertTrue(lottoGame.getLottos().getLottos().get(index).getNumbers().getLottoNumbers().containsAll(winnerNumbers)));
    }

    @Test
    @DisplayName("로또게임의 drawLotto 함수 호출 시 각 로또들의 당첨상태(Award)가 변경된다.")
    void drawLotto() {
        lottoGame.purchase(TICKET_NUMBER, new ListSortStrategy());
        for (Lotto lotto: lottoGame.getLottos().getLottos()) {
            assertEquals(lotto.getAward(), Award.UNIDENTIFIED);
        }

        lottoGame.drawLotto(winnerLottoNumbers);
        for (Lotto lotto: lottoGame.getLottos().getLottos()) {
            assertEquals(lotto.getAward(), Award.FIRST);
        }

    }

    @Test
    @DisplayName("정렬된 전략으로 로또티켓을 구입, 당첨로또를 확인, 1등 로또 티켓의 갯수는 티켓 갯수와 같다. 다른 티켓의 수는 0개이다.")
    void countWinners() {
        lottoGame.purchase(TICKET_NUMBER, new ListSortStrategy());
        lottoGame.drawLotto(winnerLottoNumbers);
        assertEquals(lottoGame.countWinners(Award.FIRST), TICKET_NUMBER);
        assertEquals(lottoGame.countWinners(Award.SECOND), 0);
        assertEquals(lottoGame.countWinners(Award.THIRD), 0);
        assertEquals(lottoGame.countWinners(Award.FOURTH), 0);
    }
}