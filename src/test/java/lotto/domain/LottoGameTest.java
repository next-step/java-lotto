package lotto.domain;

import lotto.domain.dto.LottoPurchaseResult;
import lotto.util.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static lotto.domain.WinnerLottoTest.winnerLotto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoGameTest {

    public static final int TICKET_NUMBER = 5;
    private LottoGame lottoGame;
    private List<Lotto> lottos;
    private List<Set<Integer>> manualLottoList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Set<Integer> manualLotto = new HashSet<>();
        IntStream.rangeClosed(1,6).forEach(number -> manualLotto.add(number));
        manualLottoList.add(manualLotto);
        lottoGame = new LottoGame();
        lottos = LottoGenerator.createLottos(manualLottoList, TICKET_NUMBER);
    }

    @Test
    @DisplayName("lottoGame의 purchase함수 호출 시 인자값의 로또리스트와 응답의 로또리스트가 같은 지 확인한다.")
    void purchase() {
        LottoPurchaseResult lottoPurchaseResponse = lottoGame.purchase(lottos);
        assertEquals(lottoPurchaseResponse.getLottoList().size(), TICKET_NUMBER);
        assertTrue(lottoPurchaseResponse.getLottoList().containsAll(lottos));
    }

    @Test
    @DisplayName("로또게임의 drawLotto 함수 호출 결과 수의 총합은 티켓넘버와 같음을 확인한다.")
    void drawLotto() {
        lottoGame.purchase(lottos);
        LottoDrawResult lottoResult = lottoGame.drawLotto(winnerLotto);
        int sum = lottoResult
                .getLottoDrawResult()
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .sum();
        assertEquals(sum, TICKET_NUMBER);
    }
}