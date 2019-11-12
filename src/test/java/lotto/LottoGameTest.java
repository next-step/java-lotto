package lotto;

import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {
    @Test
    void moneyValidate() {
        int money = 900;
        assertThatThrownBy(() -> {
            Lottos lottos = LottoGame.buyLotto(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addAll() {
        String[] lottoStrings = {"1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"};
        int money = 5000;
        int expectedSize = money / 1000;

        Lottos lottos = LottoGame.buyLottoWithSelfNumbers(money, Arrays.asList(lottoStrings));

        assertThat(lottos.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("금액을 넣었을때 금액 / 1000 만큼 로또가 생성되는지 확인한다.")
    void lottoSize() {
        int money = 3000;
        int expectedSize = money / 1000;

        Lottos lottos = LottoGame.buyLotto(money);

        assertThat(lottos.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 IllegalArgumentException이 발생한다.")
    void checkBonus() {
        String testWinningNumbers = "1, 2, 3, 4, 5, 6";
        int bonus = 6;

        assertThatThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto(testWinningNumbers,  bonus);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
