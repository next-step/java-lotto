package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LottoGameTest {

    public static final int TICKET_NUMBER = 5;
    private LottoGame lottoGame = new LottoGame();
    private Set<LottoNumber> winnerNumbers = new HashSet<>();

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
    }

    @Test
    @DisplayName("lottoGame의 purchase()함수 호출 시 생성된 Lottos의 수가 ticket의 수와 같은 지 확인한다.")
    void purchase() {
        lottoGame.purchase(TICKET_NUMBER);
        assertEquals(lottoGame.getLottos().getLottos().size(), TICKET_NUMBER);
    }

    @Test
    @DisplayName("로또게임의 drawLotto 함수 호출 시 각 로또들의 당첨상태(Award)가 변경된다.")
    void drawLotto() {
        lottoGame.purchase(TICKET_NUMBER);
        for (Lotto lotto : lottoGame.getLottos().getLottos()) {
            assertEquals(lotto.getAward(), Award.UNIDENTIFIED);
        }

        lottoGame.drawLotto(winnerNumbers);
        for (Lotto lotto : lottoGame.getLottos().getLottos()) {
            assertNotEquals(lotto.getAward(), Award.UNIDENTIFIED);
        }

    }

    @Test
    @DisplayName("countWinners 함수를 호출했을 때 각각의 합이 ticket의 숫자와 같은 지 확인한다.")
    void countWinners() {
        lottoGame.purchase(TICKET_NUMBER);
        lottoGame.drawLotto(winnerNumbers);
        long countAll = lottoGame.countWinners(Award.FIRST) +
                lottoGame.countWinners(Award.SECOND) +
                lottoGame.countWinners(Award.THIRD) +
                lottoGame.countWinners(Award.FOURTH) +
                lottoGame.countWinners(Award.BANG);
        assertEquals(countAll, TICKET_NUMBER);
    }
}