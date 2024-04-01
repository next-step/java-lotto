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
        final Lotto winningLotto = lotto(new int[] {1, 2, 3, 4, 5, 6}, 45);
        final LottoResult actualLottoResult = new LottoJudge().judge(lottos(), winningLotto);
        final LottoResult expectedLottoResult = lottoResult();

        assertThat(actualLottoResult.result())
                .isEqualTo(expectedLottoResult.result());
        assertThat(actualLottoResult.profitRate())
                .isEqualTo(expectedLottoResult.profitRate());
    }

    private static List<Lotto> lottos() {
        return List.of(
                lotto(new int[] {1, 2, 3, 4, 5, 6}, 45),
                lotto(new int[] {1, 2, 3, 4, 5, 6}, 7),
                lotto(new int[] {1, 2, 3, 4, 5, 7}, 45),
                lotto(new int[] {1, 2, 3, 4, 5, 7}, 45),
                lotto(new int[] {1, 2, 3, 4, 5, 7}, 8),
                lotto(new int[] {1, 2, 3, 4, 7, 8}, 45),
                lotto(new int[] {1, 2, 3, 7, 8, 9}, 45),
                lotto(new int[] {1, 2, 7, 8, 9, 10}, 45),
                lotto(new int[] {1, 7, 8, 9, 10, 11}, 45),
                lotto(new int[] {7, 8, 9, 10, 11, 12}, 45)
        );
    }

    private static Lotto lotto(final int[] numbers, final int bonus) {
        return Lotto.from(numbers, bonus);
    }

    private static LottoResult lottoResult() {
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
