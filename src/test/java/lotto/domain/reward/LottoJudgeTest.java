package lotto.domain.reward;

import static lotto.domain.reward.LottoRank.FIRST;
import static lotto.domain.reward.LottoRank.FOURTH;
import static lotto.domain.reward.LottoRank.NONE;
import static lotto.domain.reward.LottoRank.SECOND;
import static lotto.domain.reward.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

class LottoJudgeTest {

    @Test
    @DisplayName("당첨 번호와 로또 번호를 비교하여 동일한 갯수에 따라 순위를 부여한다.")
    void Judge_LottoRank() {
        final Lotto winningLotto = Lotto.from(toLottoNumbers(1, 2, 3, 4, 5, 6));
        final LottoResult actualLottoResult = new LottoJudge().judge(lottos(), winningLotto);
        final LottoResult expectedLottoResult = lottoResult();

        assertThat(actualLottoResult.result())
                .isEqualTo(expectedLottoResult.result());
        assertThat(actualLottoResult.profitRate())
                .isEqualTo(expectedLottoResult.profitRate());
    }

    private static List<Lotto> lottos() {
        return List.of(
                Lotto.from(toLottoNumbers(1, 2, 3, 4, 5, 6)), // FIRST
                Lotto.from(toLottoNumbers(1, 2, 3, 4, 5, 6)), // FIRST
                Lotto.from(toLottoNumbers(1, 2, 3, 4, 5, 7)), // SECOND
                Lotto.from(toLottoNumbers(1, 2, 3, 4, 5, 7)), // SECOND
                Lotto.from(toLottoNumbers(1, 2, 3, 4, 5, 7)), // SECOND
                Lotto.from(toLottoNumbers(1, 2, 3, 4, 7, 8)), // THIRD
                Lotto.from(toLottoNumbers(1, 2, 3, 7, 8, 9)), // FOURTH
                Lotto.from(toLottoNumbers(1, 2, 7, 8, 9, 10)), // NONE
                Lotto.from(toLottoNumbers(1, 7, 8, 9, 10, 11)), // NONE
                Lotto.from(toLottoNumbers(7, 8, 9, 10, 11, 12)) // NONE
        );
    }

    private static Set<LottoNumber> toLottoNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static LottoResult lottoResult() {
        final Map<LottoRank, Long> result = Map.of(
                FIRST, 2L,
                SECOND, 3L,
                THIRD, 1L,
                FOURTH, 1L,
                NONE, 3L
        );

        return LottoResult.from(result);
    }
}
