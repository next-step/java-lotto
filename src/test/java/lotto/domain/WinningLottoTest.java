package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("객체 동등성 확인")
    void create() {
        // given
        Number bonusNumber = Number.from(7);

        // when
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), bonusNumber);

        // then
        assertThat(winningLotto).isEqualTo(WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), bonusNumber));
    }

    @Test
    @DisplayName("1등 당첨 확인")
    void rank() {
        // given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), Number.from(7));

        // when
        Rank rank = winningLotto.rank(Lotto.from(new TestLottoNumberGenerator()));

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 당첨 확인")
    void rank_second() {
        // given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(new TestLottoNumberGenerator()), Number.from(7));
        Set<Integer> lottoNumbers = new HashSet<>(Arrays.asList(1,2,3,4,5,7));

        // when
        Rank rank = winningLotto.rank(Lotto.from(lottoNumbers));

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
