package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {
    @Test
    void moneyValidate() {
        int money = 900;
        assertThatThrownBy(() -> {
            LottoGame lottoGame = new LottoGame(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액을 넣었을때 금액 / 1000 만큼 로또가 생성되는지 확인한다.")
    void lottoSize() {
        int money = 3000;
        int expectedSize = money / 1000;

        LottoGame lottoGame = new LottoGame(money);

        assertThat(lottoGame.lottoSize()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,2,3,4,5,6"})
    @DisplayName("당첨 번호를 셋팅한다.")
    void winningLotto(String winningLottoString) {
        int money = 1000;
        LottoGame lottoGame = new LottoGame(money);

        lottoGame.winningLotto(winningLottoString);

        assertThat(lottoGame.isInitWinningLotto()).isTrue();
    }
}
