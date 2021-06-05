package study.ascii92der.lotto.step3to5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class LottoGameTest {

    @Test
    @DisplayName("LottoGame 최종 테스트")
    void run() {
        String input = "14000\n1,2,3,4,5,6\n13";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView(System.in);
        ResultView resultView = new ResultView();
        LottoGame lottoGame = new LottoGame(inputView, resultView);

        lottoGame.run();
    }
}