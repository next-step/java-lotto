package lotto.domain.reward;

import static lotto.domain.reward.LottoRank.FIFTH;
import static lotto.domain.reward.LottoRank.FIRST;
import static lotto.domain.reward.LottoRank.FOURTH;
import static lotto.domain.reward.LottoRank.NONE;
import static lotto.domain.reward.LottoRank.SECOND;
import static lotto.domain.reward.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

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
        final List<Lotto> autoLottos = List.of(
                lotto(1, 2, 3, 4, 5, 6),
                lotto(1, 2, 3, 4, 5, 6),
                lotto(1, 2, 3, 4, 5, 7),
                lotto(1, 2, 3, 4, 5, 7),
                lotto(1, 2, 3, 4, 5, 8),
                lotto(1, 2, 3, 4, 7, 8),
                lotto(1, 2, 3, 7, 8, 9),
                lotto(1, 2, 7, 8, 9, 10),
                lotto(1, 7, 8, 9, 10, 11),
                lotto(7, 8, 9, 10, 11, 12)
        );
        final WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6), 7);
        final Lottos lottos = new Lottos(List.of(), autoLottos);

        return new LottoJudge().judge(lottos, winningLotto);
    }

    private Lotto lotto(final int... numbers) {
        final List<Integer> lottoNumbers = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toUnmodifiableList());

        return Lotto.from(lottoNumbers);
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
