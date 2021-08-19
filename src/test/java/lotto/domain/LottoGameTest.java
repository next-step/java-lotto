package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @DisplayName("입력된 금액/로또 갯수 만큼 로또 티켓을 구입함.")
    @Test
    void buy_ticket_from_input_price_test() {
        LottoGame lottoGame = new LottoGame(14000, new LottoNumberRandomSelector());
        assertThat(lottoGame.size()).isEqualTo(14);
    }

    @DisplayName("6개를 맞으면 1등이다.")
    @Test
    void check_result() {
        LottoGame lottoGame = new LottoGame(1000, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoGame.checkResult(
            new LottoNumbers(() -> Arrays.asList(1, 2, 3, 4, 5, 6))))
            .isEqualTo(Collections.singletonList(LottoRank.FIRST));
    }
}
