package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @Test
    void 보너스_번호가_1보다_작거나_45보다_크면_예외발생() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 한다");

        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 한다");
    }


    @Test
    void 같은_번호는_동등성을_가진다() {
        BonusNumber bonusNumber1 = new BonusNumber(7);
        BonusNumber bonusNumber2 = new BonusNumber(7);

        assertThat(bonusNumber1).isEqualTo(bonusNumber2);
    }

}
