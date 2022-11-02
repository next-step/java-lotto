package lotto.domain;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @Test
    void 로또로_발급된_번호는_정렬() {
        assertThat(new Lotto("1, 2, 3, 4, 5, 6")).isEqualTo(new Lotto("6,5,4,3,2,1"));
    }

    @Test
    void 로또는_6개의_중복되지_않은_숫자() {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    new Lotto("1, 1, 1, 1, 1");
                });
    }

    @Test
    void 당첨_번호와_비교하여_몇등인지_계산() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber(7);

        assertThat(lotto.getResult(winningLotto, bonusNumber)).isEqualTo(LottoResult.FIRST_PRIZE);
    }
}
