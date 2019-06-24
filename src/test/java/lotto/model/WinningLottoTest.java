package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("6개의 로또번호와 1개의 보너스 번호를 갖는 당첨번호 생성")
    @Test
    void createWinningLotto() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Number bonus = Number.of(7);

        WinningLotto winningLotto = WinningLotto.generate(lotto, bonus);

        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto).isEqualTo(new WinningLotto(ofLotto(1, 2, 3, 4, 5, 6), Number.of(7)));
    }
}
