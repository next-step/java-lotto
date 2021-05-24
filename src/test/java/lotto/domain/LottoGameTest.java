package lotto.domain;

import lotto.ui.IOManager;
import lotto.ui.Input;
import lotto.ui.StandardOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @DisplayName("모든 로직이 오류 없이 수행되는 통합 테스트")
    @Test
    void lottoIntegrationTest01() {

        IOManager ioManager = new IOManager(new Input() {

            private final int[] params = new int[] {5000, 7};
            private int paramsIndex = 0;

            @Override
            public int nextInt() {
                return params[paramsIndex++]; // 로또 5개 구매, 보너스 번호 7
            }

            @Override
            public String nextLine() {
                return "1, 2, 3, 4, 5, 6"; // 당첨 로또의 숫자
            }
        }, new StandardOutput());

        LottoGame lottoGame = new LottoGame(ioManager);
        lottoGame.progress();
    }
}
