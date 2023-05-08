package lotto.step4.domain;

import lotto.step4.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.step4.domain.Fixture.lottoStrategyFake;
import static org.assertj.core.api.Assertions.assertThat;

class LottoCountTest {
    @Test
    @DisplayName("수동 구매 입력하여 최종 결과 확인")
    void manualLotto() {
        // GIVEN
        int price = 2_000;
        int manualLottoCount = 1;
        List<Set<Integer>> manualLotto = List.of(Set.of(3, 4, 5, 6, 7, 8));

        LottoCount lottoCount = new LottoCount(price, manualLottoCount, manualLotto);
        Lottos lottos = new Lottos(lottoStrategyFake, lottoCount);
        int 보너스번호 = 6;
        Set<Integer> 당첨번호 = Set.of(1, 2, 3, 4, 5, 7);

        // WHEN
        WinningNumbers winningNumbers = new WinningNumbers(당첨번호, 보너스번호);

        // THEN
        assertThat(winningNumbers.getWinnerStat(lottos).getStat()).containsKeys(Rank.SECOND, Rank.FOURTH);
    }
}