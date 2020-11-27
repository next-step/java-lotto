package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import lotto.domain.game.LottoNumberSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-18.
 */
class LottoTest {

    @org.junit.jupiter.api.Test
    @DisplayName("로또 한 회차 객체를 생성한다")
    void generate_lotto_set() {
        // given
        LottoNumberSet lottoNumberSet = LottoNumberSet
                .of(Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));

        // when
        Lotto lotto = Lotto.of(lottoNumberSet);

        // then
        Assertions.assertEquals(lotto.number(), lottoNumberSet.value());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("같은 번호를 가진 로또 객체는 같다")
    void is_lotto_set_same() {
        // given
        LottoNumberSet lottoNumberSet = LottoNumberSet
                .of(Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toList()));

        // when
        Lotto lotto = Lotto.of(lottoNumberSet);
        Lotto lotto2 = Lotto.of(lottoNumberSet);

        // then
        assertThat(lotto.number()).containsExactlyElementsOf(lotto2.number());

    }

}
