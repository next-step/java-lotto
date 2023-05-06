package lotto.step3.domain;

import lotto.step3.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.step3.domain.Fixture.TestLotto;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {
    @Test
    @DisplayName("기존 5개 번호가 일치하고 나머지 하나의 번호가 보너스 번호와 일치하면 MatchNumber-SECOND 반환")
    void bonusNumber() {
        // GIVEN
        Lotto l1 = TestLotto.of(1, 2, 3, 4, 5, 7);
        List<Lotto> 당첨번호와_한자리가_다르며_보너스번호를_가지는_로또번호 = List.of(l1);
        Set<Integer> 당첨번호 = Set.of(1, 2, 3, 4, 5, 6);
        int 보너스번호 = 7;

        // WHEN
        WinningNumbers winningNumbers = new WinningNumbers(당첨번호, 보너스번호);
        Lottos lottos = new Lottos(당첨번호와_한자리가_다르며_보너스번호를_가지는_로또번호);
        Result result = winningNumbers.getWinnerStat(lottos);

        assertThat(result.getStat().containsKey(Rank.SECOND)).isTrue();
    }
}