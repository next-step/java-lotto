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
        final LottoJudge lottoJudge = new LottoJudge(winningLotto);

        assertThat(lottoJudge.judge(lottos()))
                .isEqualTo(lottoResult());
    }

    private static List<Lotto> lottos() {
        return List.of(
                new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 6)), // FIRST
                new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 6)), // FIRST
                new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(toLottoNumbers(1, 2, 3, 4, 7, 8)), // THIRD
                new Lotto(toLottoNumbers(1, 2, 3, 7, 8, 9)), // FOURTH
                new Lotto(toLottoNumbers(1, 2, 7, 8, 9, 10)), // NONE
                new Lotto(toLottoNumbers(1, 7, 8, 9, 10, 11)), // NONE
                new Lotto(toLottoNumbers(7, 8, 9, 10, 11, 12)) // NONE
        );
    }

    private static Set<LottoNumber> toLottoNumbers(final int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static Map<LottoRank, Long> lottoResult() {
        return Map.of(
                FIRST, 2L,
                SECOND, 3L,
                THIRD, 1L,
                FOURTH, 1L,
                NONE, 3L
        );
    }
}
