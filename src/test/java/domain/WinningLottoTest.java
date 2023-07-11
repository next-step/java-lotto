package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또는 로또와 보너스 로또 번호로 구성된다.")
    void createSuccess() {
        /* given */
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = new LottoNumber(7);

        /* when */
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);

        /* then */
        assertThat(winningLotto.getLotto()).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(winningLotto.getBonus()).isEqualTo(new LottoNumber(7));
    }

    @Test
    @DisplayName("로또의 로또 번호와 보너스 로또 번호가 중복될 경우 IllegalArgumentException을 던진다.")
    void createFailWithDuplicatedNumber() {
        /* given */
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = new LottoNumber(3);

        /* when & then */
        assertThatThrownBy(() -> new WinningLotto(lotto, bonus)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
