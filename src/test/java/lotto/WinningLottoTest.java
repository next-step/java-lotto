package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.LottoNumber.convertToLottoNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    public void 보너스번호가_당첨번호와_중복이_발생하면_예외가_발생한다() {
        List<LottoNumber> winningNumbers = convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 6;

        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    public void 당첨번호와_구매_로또정보를_기반으로_등수정보를_반환한다_보너스번호포함() {
        WinningLotto winningLotto = new WinningLotto(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6)), 7);

        Lotto firstRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 7)));
        Lotto thirdRankLotto = Lotto.of(convertToLottoNumber(List.of(1, 2, 3, 4, 5, 38)));

        assertThat(winningLotto.checkLottoRank(firstRankLotto)).isEqualTo(Rank.FIRST);
        assertThat(winningLotto.checkLottoRank(secondRankLotto)).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.checkLottoRank(thirdRankLotto)).isEqualTo(Rank.THIRD);
    }

}
