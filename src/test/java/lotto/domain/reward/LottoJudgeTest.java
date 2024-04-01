package lotto.domain.reward;

import static lotto.domain.reward.LottoRank.FIFTH;
import static lotto.domain.reward.LottoRank.FIRST;
import static lotto.domain.reward.LottoRank.FOURTH;
import static lotto.domain.reward.LottoRank.NONE;
import static lotto.domain.reward.LottoRank.SECOND;
import static lotto.domain.reward.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class LottoJudgeTest {

    @Test
    @DisplayName("당첨 번호와 로또 번호를 비교하여 동일한 갯수에 따라 순위를 부여한다.")
    void Judge_LottoRank() {
        final LottoResult actualLottoResult = actualLottoResult();
        final LottoResult expectedLottoResult = expectedLottoResult();

        assertThat(actualLottoResult.result())
                .isEqualTo(expectedLottoResult.result());
        assertThat(actualLottoResult.profitRate())
                .isEqualTo(expectedLottoResult.profitRate());
    }

    private LottoResult actualLottoResult() {
        final List<Lotto> lottos = List.of(
                Lotto.from(new int[] {1, 2, 3, 4, 5, 6}),
                Lotto.from(new int[] {1, 2, 3, 4, 5, 6}),
                Lotto.from(new int[] {1, 2, 3, 4, 5, 7}),
                Lotto.from(new int[] {1, 2, 3, 4, 5, 7}),
                Lotto.from(new int[] {1, 2, 3, 4, 5, 8}),
                Lotto.from(new int[] {1, 2, 3, 4, 7, 8}),
                Lotto.from(new int[] {1, 2, 3, 7, 8, 9}),
                Lotto.from(new int[] {1, 2, 7, 8, 9, 10}),
                Lotto.from(new int[] {1, 7, 8, 9, 10, 11}),
                Lotto.from(new int[] {7, 8, 9, 10, 11, 12})
        );
        final WinningLotto winningLotto = WinningLotto.of(new int[] {1, 2, 3, 4, 5, 6}, 7);

        return new LottoJudge().judge(lottos, winningLotto);
    }

    private LottoResult expectedLottoResult() {
        final Map<LottoRank, Long> result = Map.of(
                FIRST, 2L,
                SECOND, 2L,
                THIRD, 1L,
                FOURTH, 1L,
                FIFTH, 1L,
                NONE, 3L
        );

        return new LottoResult(result);
    }
}
