package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("입력된 금액만큼 로또티켓을 구입하는 테스트")
    @Test
    void buy_ticket_from_input_price_test() {
        Lotto lotto = new Lotto(14000);
        assertThat(lotto.getGameNum()).isEqualTo(14);
    }

    @DisplayName("당첨 번호를 선택하는 테스트")
    @Test
    void set_winning_numbers() {
        Lotto lotto = new Lotto(1000);
        lotto.setWinningNumber("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getWinningNumber()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("")
    @Test
    void name() {
        LottoGame lottoGame = new LottoGame(1000);
        System.out.println(lottoGame.getTickets().get(0).getNumberString());
    }
}
