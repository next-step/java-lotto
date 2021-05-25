package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.Lotto.LOTTO_NUMBER_SIZE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @DisplayName("로또는 6개의 서로 다른 번호로 만들어진다.")
    @Test
    void different_lotto_numbers() {
        //given
        final int expected = 6;

        //when
        final Lotto lottoNumbers = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));

        //then
        assertThat(lottoNumbers.size()).isEqualTo(expected);
    }

    @DisplayName("중복된 로또번호가 있을시 예외를 발생시킨다.")
    @Test
    void equals_lotto_numbers_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(2),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        )))
                .withMessageMatching(LOTTO_NUMBER_SIZE_MESSAGE);
    }

    @DisplayName("로또번호가 6개 미만이면 예외를 발생시킨다.")
    @Test
    void lotto_number_less_than_6_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5)
        )))
                .withMessageMatching(LOTTO_NUMBER_SIZE_MESSAGE);
    }

    @DisplayName("로또의 당첨은 로또숫자가 같은지를 확인한다.")
    @Test
    void match_count() {
        //given
        final Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        final Lotto toCompareLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8)
        ));
        final int expected = 4;

        //when
        final int matchCount = lotto.matchCount(toCompareLotto);

        //then
        assertThat(matchCount).isEqualTo(expected);
    }

    @DisplayName("로또 당첨번호가 보너스번호와 맞는지 확인한다.")
    @Test
    void match_bonus_number() {
        //given
        final int bonusNumber = 45;
        final Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(bonusNumber)
        ));
        final LottoNumber lottoNumber = new LottoNumber(bonusNumber);

        //when
        final boolean matchBonusNumber = lotto.matchBonusNumber(lottoNumber);

        //then
        assertThat(matchBonusNumber).isTrue();
    }
}
