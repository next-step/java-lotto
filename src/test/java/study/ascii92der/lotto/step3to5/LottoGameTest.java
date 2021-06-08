package study.ascii92der.lotto.step3to5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoGameTest {

    @Test
    @DisplayName("LottoGame 최종 테스트")
    void run() {
        LottoOutput lottoOutput = new ResultView();
        LottoGame lottoGame = new LottoGame(new LottoInput() {
            @Override
            public LottoPrice inputMoney() {
                return new LottoPrice(14000);
            }

            @Override
            public LottoPrice inputManualLottoCount() {
                return new LottoPrice(3000);
            }

            @Override
            public Lottos inputManualLottos(LottoPrice manualLottoPrice) {
                List<Lotto> lottos = new ArrayList<>(Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(11, 21, 31, 41, 15, 16)),
                        new Lotto(Arrays.asList(10, 20, 30, 40, 25, 36))));
                return new Lottos(lottos);
            }

            @Override
            public Lotto inputWinnerNumbers() {
                return new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            }

            @Override
            public LottoNumber inputBonusNumber() {
                return new LottoNumber(10);
            }
        }, lottoOutput);

        lottoGame.run();
    }
}