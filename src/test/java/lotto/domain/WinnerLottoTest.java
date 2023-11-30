package lotto.domain;

import static lotto.domain.Rank.SECOND;
import static lotto.domain.WinnerLotto.BONUS_NUMBER_OVERLAPPING_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerLottoTest {
    @Test
    @DisplayName("당첨 로또와 보너스 숫자가 겹치면 예외를 던진다.")
    void create_bonus_exception() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        // when // then
        assertThatThrownBy(() -> new WinnerLotto(lotto, LottoNumber.valueOf(6)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OVERLAPPING_EXCEPTION);
    }

    @Test
    @DisplayName("당첨 로또와 실제 구매한 로또를 비교해 등수를 알려준다.")
    void find_rank() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(1, 2, 3, 4, 5, 7), LottoNumber.valueOf(6));

        // when
        Rank result = winnerLotto.findRankOf(lotto);

        // then
        assertThat(result).isEqualTo(SECOND);
    }
}
