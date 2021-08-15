package lotto.domain;

import lotto.domain.dto.LottoPurchaseResponse;
import lotto.util.LottoListGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoTest.winnerLotto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoGameTest {

    public static final int TICKET_NUMBER = 5;
    private LottoGame lottoGame;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
        lottos = LottoListGenerator.creatLottos(TICKET_NUMBER);
    }

    @Test
    @DisplayName("lottoGame의 purchase함수 호출 시 인자값의 로또리스트와 응답의 로또리스트가 같은 지 확인한다.")
    void purchase() {
        LottoPurchaseResponse lottoPurchaseResponse = lottoGame.purchase(lottos);
        assertEquals(lottoPurchaseResponse.getLottoList().size(), TICKET_NUMBER);
        assertTrue(lottoPurchaseResponse.getLottoList().containsAll(lottos));
    }

    @Test
    @DisplayName("로또게임의 drawLotto 함수 호출 결과 수의 총합은 티켓넘버와 같음을 확인한다.")
    void drawLotto() {
        lottoGame.purchase(lottos);
        LottoDrawResponse lottoResult = lottoGame.drawLotto(winnerLotto);
        int sum = lottoResult.getLottoResult()
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        assertEquals(sum, TICKET_NUMBER);
    }
}