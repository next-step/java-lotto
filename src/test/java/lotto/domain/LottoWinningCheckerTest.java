package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningCheckerTest {
    @Test
    @DisplayName("당첨로또 확인 : 3개 수 당첨 2개")
    void two_win_lotto_test() {
        LottoWinningChecker checker = new LottoWinningChecker();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1,2,4,6,9,10)),
                new Lotto(Arrays.asList(7,11,14,15,35,38)),
                new Lotto(Arrays.asList(2,7,10,13,34,41))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        Map<WinType, Integer> results = checker.checkWin(lottos, winNumbers);
        assertThat(results).containsEntry(WinType.THREE_MATCH, 2);
    }

    @Test
    @DisplayName("당첨로또 확인 : 당첨 안된 로또 2개")
    void zero_win_lotto_test() {
        LottoWinningChecker checker = new LottoWinningChecker();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(3,4,22,36,39,45)),
                new Lotto(Arrays.asList(7,11,14,15,35,38))
        );
        String winNumbers = "1, 2, 5, 10, 34, 43";
        Map<WinType, Integer> results = checker.checkWin(lottos, winNumbers);
        assertThat(results).containsEntry(WinType.NO_MATCH, 2);
    }
}
