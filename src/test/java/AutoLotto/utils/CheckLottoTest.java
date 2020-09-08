package AutoLotto.utils;

import AutoLotto.domain.lotto.BuzzLotto;
import AutoLotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CheckLottoTest {

    @Test
    void canMakeBuzzLotto() {

//        assertThat(CheckLotto.makeBuzzLotto("1,3,4,15,5,44")).hasSize(6);
//        assertThat(CheckLotto.makeBuzzLotto("1,3,4,15,5,44").get(0)).isEqualTo(new LottoNumber(1));
    }

    @Test
    void canNotMakeBuzzLotto() {
        //not 6
        assertThatThrownBy(() -> CheckLotto.makeBuzzLotto("1,3,4,15,5"))
                .isInstanceOf(RuntimeException.class);

        //6 but not distinct
        assertThatThrownBy(() -> CheckLotto.makeBuzzLotto("1,3,4,15,5,5"))
                .isInstanceOf(RuntimeException.class);

        //6 but over 45
        assertThatThrownBy(() -> CheckLotto.makeBuzzLotto("1,3,4,15,5,100"))
                .isInstanceOf(RuntimeException.class);

        //6 but blank
        assertThatThrownBy(() -> CheckLotto.makeBuzzLotto("1,,4,15,5,100"))
                .isInstanceOf(RuntimeException.class);

        //6 but not number
        assertThatThrownBy(() -> CheckLotto.makeBuzzLotto("1,!,4,15,5,100"))
                .isInstanceOf(RuntimeException.class);
    }
}