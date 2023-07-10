package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("6개의 일반 번호와 1개의 보너스 번호로 이루어진다.")
    void containsSixNumbersAndOneBonusNumberTest() {
        //given
        Lotto lotto = Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(7));

        //when, then
        assertThat(winningLotto.getLottoNumbers().getLottoNumbers()).hasSize(6);
        assertThat(winningLotto.getBonus()).isInstanceOf(LottoNumber.class);
    }
}
