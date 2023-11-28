package lotto.domain;

import static lotto.domain.WinnerLotto.BONUS_NUMBER_OVERLAPPING_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerLottoTest {

    @Test
    @DisplayName("당첨로또와 일반로또를 비교해 숫자가 몇개가 일치하는지 알려준다.")
    void count_of_match() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinnerLotto winnerLotto = new WinnerLotto(lotto, LottoNumber.valueOf(bonusNumber));

        // when
        int result = winnerLotto.countOfMatch(createLotto());

        // then
        assertThat(result).isEqualTo(4);
    }

    private Set<LottoNumber> createLotto() {
        Set<LottoNumber> lotto = new HashSet<>();
        lotto.add(LottoNumber.valueOf(1));
        lotto.add(LottoNumber.valueOf(2));
        lotto.add(LottoNumber.valueOf(4));
        lotto.add(LottoNumber.valueOf(6));
        lotto.add(LottoNumber.valueOf(7));
        lotto.add(LottoNumber.valueOf(41));
        return lotto;
    }

    @ParameterizedTest
    @DisplayName("일반 로또에 당첨 숫자가 존재하는지 알려준다.")
    @CsvSource(value = {"7, true", "8, false"})
    void contains_bonus(int bonusNumber, boolean expected) {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = new WinnerLotto(lotto, LottoNumber.valueOf(bonusNumber));

        // when
        boolean result = winnerLotto.containsBonus(createLotto());

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 로또와 보너스 숫자가 겹치면 예외를 던진다.")
    void create_bonus_exception() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        // when // then
        Assertions.assertThatThrownBy(() -> new WinnerLotto(lotto, LottoNumber.valueOf(6)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OVERLAPPING_EXCEPTION);
    }
}