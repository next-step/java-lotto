package src.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void 보너스_번호는_이미_뽑힌_번호와_중복될_수_없다() {
        // given
        Lotto lotto = Lotto.of(Set.of(
                GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6)));
        GameNumber duplicateBonusNumber = GameNumber.of(1);

        // when then
        assertThatThrownBy(() -> WinningLotto.of(lotto, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 이미 뽑힌 번호와 중복될 수 없습니다.");
    }
}
