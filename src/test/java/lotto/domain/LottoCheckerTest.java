package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {
    @Test
    @DisplayName("당첨 여부 테스트 (로또 구매가 없는 경우)")
    void checkLottosTestByEmpty() throws Exception {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningStatistics stats = new LottoChecker().check(winningLotto, List.of());

        assertThat(stats.generateFormattedReport()).containsExactly(
            "6개 일치 (2000000000원) - 0개",
            "5개 일치 (1500000원) - 0개",
            "4개 일치 (50000원) - 0개",
            "3개 일치 (5000원) - 0개",
            "꽝 - 0개"
        );
    }

    @Test
    @DisplayName("당첨 여부 테스트 (로또 구매가 있는 경우)")
    void checkLottosTest() {
        List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 7, 8)),
            new Lotto(List.of(1, 2, 3, 7, 8, 9)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningStatistics stats = new LottoChecker().check(winningLotto, lottos);

        assertThat(stats.generateFormattedReport()).containsExactly(
            "6개 일치 (2000000000원) - 1개",
            "5개 일치 (1500000원) - 1개",
            "4개 일치 (50000원) - 1개",
            "3개 일치 (5000원) - 1개",
            "꽝 - 1개"
        );
    }
}
