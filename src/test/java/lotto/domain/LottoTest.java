package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-18.
 */
class LottoTest {

    @Test
    @DisplayName("로또 한 회차 객체를 생성한다")
    void generate_lotto_set() {
        // given
        LottoNumber lottoNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        Lotto lotto = Lotto.of(lottoNumber);

        // then
        assertThat(lotto.number()).containsExactly(1, 2, 3, 4, 5, 6);

    }

    @Test
    @DisplayName("같은 번호를 가진 로또 객체는 같다")
    void is_lotto_set_same() {
        // given
        LottoNumber lottoNumber = LottoNumber.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        Lotto lotto = Lotto.of(lottoNumber);
        Lotto lotto2 = Lotto.of(lottoNumber);

        // then
        assertThat(lotto.number()).containsExactlyElementsOf(lotto2.number());

    }

}
