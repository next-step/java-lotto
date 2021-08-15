package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @DisplayName("입력된 금액만큼 로또티켓을 구입하는 테스트")
    @Test
    void buy_ticket_from_input_price_test() {
        LottoGame lottoGame = new LottoGame(14000);
        assertThat(lottoGame.getGameNum()).isEqualTo(14);
    }

    @DisplayName("당첨 번호를 선택하는 테스트")
    @Test
    void set_winning_numbers() {
        LottoGame lottoGame = new LottoGame(1000);
        lottoGame.setWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoGame.getWinningNumber()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
