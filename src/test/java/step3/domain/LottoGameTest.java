package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    private LottoGame lottoGame;

    @Test
    @DisplayName("로또 구매 개수 테스트")
    public void buyPriceTest() {
        lottoGame = new LottoGame(14000);
        assertThat(lottoGame.buyQuantity()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 살 금액이 아닌 금액 테스트")
    public void buyPriceTest2() {
        assertThatThrownBy(() -> {
            lottoGame = new LottoGame(900);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
