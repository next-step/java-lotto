package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    void 보너스번호가_당첨번호에_포함되면_예외() {
        List<Integer> winningNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 3;

        assertThatThrownBy(() -> new BonusNumber(bonusNum, winningNums))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("당첨 번호에 보너스 넘버가 포함되어있습니다.");
    }

    @Test
    void 보너스번호가_Lotto와_일치하면_true() {
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertThat(bonusNumber.isMatch(lotto)).isTrue();
    }

    @Test
    void 보너스번호가_Lotto와_일치하지_않으면_false() {
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(bonusNumber.isMatch(lotto)).isFalse();
    }
}
