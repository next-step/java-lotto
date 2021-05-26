package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호에 존재하는 보너스 번호를 입력하면 에외가 발생한다")
    @Test
    void validate_bonusNumber() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        LottoNumber bonusNumber = LottoNumber.from(6);

        // when

        // then
        assertThatThrownBy(() -> WinningLotto.of(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 당첨 번호에 포함되지 않아야 합니다.");
    }

    @DisplayName("당첨번호와 모두 일치하면 1등이 당첨된다")
    @Test
    void rank_first() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), LottoNumber.from(10));

        // when
        Rank rank = winningLotto.getRank(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨번호와 5개 일치, 보너스번호 일치하면 2등이 당첨된다")
    @Test
    void rank_second() {
        // given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), LottoNumber.from(10));
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 10));

        // when
        Rank rank = winningLotto.getRank(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("당첨번호와 5개 일치하면 3등이 당첨된다")
    @Test
    void rank_third() {
        // given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), LottoNumber.from(10));
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));

        // when
        Rank rank = winningLotto.getRank(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("당첨번호와 4개 일치하면 4등이 당첨된다")
    @Test
    void rank_fourth() {
        // given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), LottoNumber.from(10));
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 7, 8));

        // when
        Rank rank = winningLotto.getRank(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("당첨번호와 3개 일치하면 5등이 당첨된다")
    @Test
    void rank_fifth() {
        // given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), LottoNumber.from(10));
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 7, 8, 9));

        // when
        Rank rank = winningLotto.getRank(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
}
