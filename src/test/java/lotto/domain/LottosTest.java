package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.IntStream;

import static lotto.domain.LottoTest.winnerLotto;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {

    private final int TICKET_NUMBER = 3;
    private Set<LottoNumber> lottoNumberList = new HashSet<>();
    private Lotto lotto;
    private List<Lotto> lottoList = new ArrayList<>();
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> lottoNumberList.add(new LottoNumber(number)));
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
    @DisplayName("1등로또로 생성한 Lottos의 drawLotto 함수 호출 시 모두 1등임을 확인한다.")
    void drawLottos() {
        LottoDrawResponse lottoDrawResponse = lottos.drawLottos(winnerLotto);
        assertEquals(lottoDrawResponse.getLottoResult().get(Award.FIRST), TICKET_NUMBER);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:3","SECOND:0"},delimiter = ':')
    @DisplayName("Award 파라미터와 함께 getWinners 함수를 호출하면 당첨 로또의 수를 리턴한다")
    void countWinners(String type, int match) {
        LottoDrawResponse lottoDrawResponse = lottos.drawLottos(winnerLotto);
        Map<Award, Integer> lottoResult = lottoDrawResponse.getLottoResult();
        assertEquals(lottoResult.get(Award.valueOf(type)), match);
    }
}