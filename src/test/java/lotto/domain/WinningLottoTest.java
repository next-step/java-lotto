package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    @Test
    @DisplayName("보너스번호가 당첨번호와 중복")
    void create_validate() {
        Lotto lotto = new Lotto(new LottoNumbers(new int[]{1, 2, 3, 4, 5, 6}));
        LottoNumber bobusNum = new LottoNumber(6);
        assertThatThrownBy(()-> new WinningLotto(lotto, bobusNum)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 생성")
    void create_normal() {
        Lotto lotto = new Lotto(new LottoNumbers(new int[]{1, 2, 3, 4, 5, 6}));
        LottoNumber bonusNum = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNum);
        Assertions.assertThat(winningLotto.getMatchCount(lotto)).isEqualTo(6);
        Assertions.assertThat(winningLotto.isBonusMatch(lotto)).isFalse();

    }
}
