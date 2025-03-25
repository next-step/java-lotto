package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    public void 당첨번호와_로또정보를_기반으로_등수정보를_반환한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto firstRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        firstRankLotto.determineLottoResult(winningNumbers);

        Lotto thirdRankLotto = new Lotto(List.of(1, 2, 3, 4, 10, 20));
        thirdRankLotto.determineLottoResult(winningNumbers);

        Lotto noPrizeRankLotto = new Lotto(List.of(1, 2, 11, 23, 33, 38));
        noPrizeRankLotto.determineLottoResult(winningNumbers);

        assertThat(firstRankLotto.getRank()).isEqualTo(Rank.FIRST);
        assertThat(thirdRankLotto.getRank()).isEqualTo(Rank.THIRD);
        assertThat(noPrizeRankLotto.getRank()).isEqualTo(Rank.NO_PRIZE);
    }

    @Test
    public void 생성된_로또_번호에_대해_조작연산을_진행하면_예외_발생() {
        List<Integer> numbers = LottoGenerator.generate().getNumbers();
        assertThatThrownBy(() -> numbers.add(1))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
