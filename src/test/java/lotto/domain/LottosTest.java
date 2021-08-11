package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    private final int TICKET_NUMBER = 3;
    private Set<LottoNumber> winnerNumbers = new HashSet<>();
    private Set<LottoNumber> lottoNumberList = new HashSet<>();
    private Lotto winnerLotto;
    private Lotto lotto;
    private List<Lotto> lottoList = new ArrayList<>();
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
        IntStream.rangeClosed(1, 6).forEach(number -> lottoNumberList.add(new LottoNumber(number)));
        winnerLotto = new Lotto(winnerNumbers);
        lotto = new Lotto(lottoNumberList);

        IntStream.range(0, TICKET_NUMBER).forEach(index -> lottoList.add(lotto));

        lottos = new Lottos(lottoList);
    }

    @Test
    @DisplayName("일급 콜렉션 Lottos의 사이즈는 로또티켓의 갯수임을 확인한다.")
    void size() {
        assertEquals(lottos.size(), TICKET_NUMBER);
    }

    @Test
    @DisplayName("drawLottos 함수를 호출했을때 각 lotto의 award 상태가 변경됨을 확인한다.")
    void drawLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            assertEquals(lotto.getAward(),Award.UNIDENTIFIED);
        }

        lottos.drawLottos(winnerLotto);

        for (Lotto lotto : lottos.getLottos()) {
            assertEquals(lotto.getAward(),Award.FIRST);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:3","SECOND:0"},delimiter = ':')
    @DisplayName("Award 파라미터와 함께 getWinners 함수를 호출하면 당첨 로또의 수를 리턴한다")
    void countWinners(String type, int match) {
        lottos.drawLottos(winnerLotto);
        assertEquals(lottos.countWinners(Award.valueOf(type)), match);
    }
}