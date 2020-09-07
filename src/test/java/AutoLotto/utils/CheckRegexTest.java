package AutoLotto.utils;

import AutoLotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CheckRegexTest {

    @Test
    void canMakeBuzzLotto() {

        assertThat(CheckRegex.makeBuzzLotto("1,3,4,15,5,45"))
                .hasSize(6).containsExactly(new LottoNumber(1), new LottoNumber(3), new LottoNumber(4),
                                            new LottoNumber(15), new LottoNumber(5), new LottoNumber(45));
    }

    @Test
    void canNotMakeBuzzLotto() {
        //not 6
        assertThatThrownBy(() -> CheckRegex.makeBuzzLotto("1,3,4,15,5"))
                .isInstanceOf(RuntimeException.class);

        //6 but not distinct
        assertThatThrownBy(() -> CheckRegex.makeBuzzLotto("1,3,4,15,5,5"))
                .isInstanceOf(RuntimeException.class);

        //6 but over 45
        assertThatThrownBy(() -> CheckRegex.makeBuzzLotto("1,3,4,15,5,100"))
                .isInstanceOf(RuntimeException.class);

        //6 but blank
        assertThatThrownBy(() -> CheckRegex.makeBuzzLotto("1,,4,15,5,100"))
                .isInstanceOf(RuntimeException.class);

        //6 but not number
        assertThatThrownBy(() -> CheckRegex.makeBuzzLotto("1,!,4,15,5,100"))
                .isInstanceOf(RuntimeException.class);
    }
}