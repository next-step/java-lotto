package lotto.domain;

import lotto.strategy.ListSortStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    private final int TICKET_NUMBER = 3;
    private List<LottoNumber> winnerNumbers = new ArrayList<>();
    private Lottos sortLottos;

    @BeforeEach
    void setUp() {
        sortLottos = new Lottos(TICKET_NUMBER, new ListSortStrategy());
        IntStream.range(1, 7).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
    }

    @Test
    @DisplayName("일급 콜렉션 Lottos의 사이즈는 로또티켓의 갯수임을 확인한다.")
    void size() {
        assertEquals(sortLottos.size(), TICKET_NUMBER);
    }

    @Test
    @DisplayName("drawLottos 함수를 호출했을때 각 lotto의 award 상태가 변경됨을 확인한다.")
    void drawLottos() {
        for (Lotto lotto : sortLottos.getLottos()) {
            assertEquals(lotto.getAward(),Award.UNIDENTIFIED);
        }

        sortLottos.drawLottos(new LottoNumbers(winnerNumbers));

        for (Lotto lotto : sortLottos.getLottos()) {
            assertEquals(lotto.getAward(),Award.FIRST);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:3","SECOND:0"},delimiter = ':')
    @DisplayName("Award 파라미터와 함께 getWinners 함수를 호출하면 당첨 로또의 수를 리턴한다")
    void countWinners(String type, int match) {
        sortLottos.drawLottos(new LottoNumbers(winnerNumbers));
        assertEquals(sortLottos.countWinners(Award.valueOf(type)), match);
    }
}