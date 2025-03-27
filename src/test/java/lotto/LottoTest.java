package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    public void 당첨번호와_구매_로또정보를_기반으로_등수정보를_반환한다() {
        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto firstRankLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto thirdRankLotto = Lotto.of(List.of(1, 2, 3, 4, 10, 20));
        Lotto noPrizeRankLotto = Lotto.of(List.of(1, 2, 11, 23, 33, 38));

        assertThat(firstRankLotto.checkLottoRank(winningNumbers)).isEqualTo(Rank.FIRST);
        assertThat(thirdRankLotto.checkLottoRank(winningNumbers)).isEqualTo(Rank.THIRD);
        assertThat(noPrizeRankLotto.checkLottoRank(winningNumbers)).isEqualTo(Rank.NO_PRIZE);
    }

    @Test
    public void 생성된_로또_번호에_대해_조작연산을_진행하면_예외_발생() {
        List<LottoNumber> numbers = LottoGenerator.generateLotto().getLottoNumbers();
        assertThatThrownBy(() -> numbers.add(new LottoNumber(1)))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
