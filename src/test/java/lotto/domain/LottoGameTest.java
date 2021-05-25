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

            // 로또 구매 금액, 수동으로 구매할 로또 수, 보너스 볼
            private final int[] intParams = new int[] {5000, 2, 7};
            private int intParamIndex = 0;

            // 버그로 인한 자리 비움, 수동 로또 번호, 수동 로또 번호, 지난 주 당첨 번호
            private final String[] stringParams = new String[] {
                "",
                "1, 2, 3, 4, 5, 6",
                "2, 3, 4, 5, 6, 7",
                "1, 2, 3, 4, 5, 6"
            };
            private int stringParamsIndex = 0;

            @Override
            public int nextInt() {
                return intParams[intParamIndex++];
            }

            @Override
            public String nextLine() {
                return stringParams[stringParamsIndex++]; // 당첨 로또의 숫자
            }
        }, new StandardOutput());

        LottoGame lottoGame = new LottoGame(ioManager);
        lottoGame.progress();
    }
}
