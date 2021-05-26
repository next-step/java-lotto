package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoFixture.번호_6개_일치;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoTest {

    @Test
    void 우승로또는_보너스번호를_추가로_가진다() {
        int bonusNumber = 45;
        WinningLotto winning = new WinningLotto(번호_6개_일치, bonusNumber);
        assertAll(
                () -> assertThat(winning.numbers()).containsAll(번호_6개_일치.numbers()),
                () -> assertThat(winning.bonusNumber).isEqualTo(bonusNumber)
        );
    }
}
