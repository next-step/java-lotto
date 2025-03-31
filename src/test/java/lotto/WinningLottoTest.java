package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.LottoNumberConverter.toLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    public void 보너스번호가_당첨번호와_중복이_발생하면_예외가_발생한다() {
        List<LottoNumber> winningNumbers = toLottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber));
    }

    @Test
    public void 당첨번호와_구매_로또정보를_기반으로_등수정보를_반환한다_보너스번호포함() {
        WinningLotto winningLotto = new WinningLotto(toLottoNumbers(List.of(1, 2, 3, 4, 5, 6)), 7);

        Lotto firstRankLotto = new ManualLotto(toLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        Lotto secondRankLotto = new ManualLotto(toLottoNumbers(List.of(1, 2, 3, 4, 5, 7)));
        Lotto thirdRankLotto = new ManualLotto(toLottoNumbers(List.of(1, 2, 3, 4, 5, 38)));
        Lotto fourthRankLottoWithBonusNumber = new ManualLotto(toLottoNumbers(List.of(1, 2, 3, 4, 7, 38)));
        Lotto fourthRankLottoWithoutBonusNumber = new ManualLotto(toLottoNumbers(List.of(1, 2, 3, 4, 17, 38)));
        Lotto fifthRankLottoWithBonusNumber = new ManualLotto(toLottoNumbers(List.of(1, 2, 3, 14, 7, 38)));
        Lotto fifthRankLottoWithoutBonusNumber = new ManualLotto(toLottoNumbers(List.of(1, 2, 3, 14, 17, 38)));

        assertThat(winningLotto.determineLottoRank(firstRankLotto)).isEqualTo(Rank.FIRST);
        assertThat(winningLotto.determineLottoRank(secondRankLotto)).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.determineLottoRank(thirdRankLotto)).isEqualTo(Rank.THIRD);
        assertThat(winningLotto.determineLottoRank(fourthRankLottoWithBonusNumber)).isEqualTo(Rank.FOURTH);
        assertThat(winningLotto.determineLottoRank(fourthRankLottoWithoutBonusNumber)).isEqualTo(Rank.FOURTH);
        assertThat(winningLotto.determineLottoRank(fifthRankLottoWithBonusNumber)).isEqualTo(Rank.FIFTH);
        assertThat(winningLotto.determineLottoRank(fifthRankLottoWithoutBonusNumber)).isEqualTo(Rank.FIFTH);
    }

}
