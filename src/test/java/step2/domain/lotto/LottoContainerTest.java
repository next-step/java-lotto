package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoContainerTest {

    private static final LottoGenerator lottoGenerator = new LottoGenerator(1, 45, 6);
    private static final LottoFactory lottoFactory = new LottoFactory(lottoGenerator);

    @DisplayName("주어진 개수만큼 로또 발급")
    @Test
    void createLottoContainer() {
        // given
        int lottoCount = 5;

        // when
        LottoContainer lottoContainer = new LottoContainer(lottoCount, lottoFactory);

        // then
         Assertions.assertThat(lottoContainer.size()).isEqualTo(lottoCount);
    }

    @DisplayName("로또 개수가 0개인 경우 IllegarArgumentException throw")
    @Test
    void createLottoContainerException() {
        // given
        int lottoCount = 0;

        // when
        Assertions.assertThatThrownBy(() -> new LottoContainer(lottoCount, lottoFactory))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 개수는 1개 이상이어야 합니다.");
    }

    @DisplayName("1등 1개, 0등 1개")
    @Test
    void checkWinningResults() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoContainer lottoContainer = new LottoContainer(List.of(lotto1, lotto2));

        // when
        List<Rank> ranks = lottoContainer.checkWinningResults(winningLotto);

        // then
        Assertions.assertThat(ranks).containsAnyOf(Rank.FIRST, Rank.NO_RANK);
    }
}
