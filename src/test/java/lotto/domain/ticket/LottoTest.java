package lotto.domain.ticket;

import lotto.enums.LottoRank;
import lotto.vo.LottoMatchResult;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void 생성_시_보너스_번호가_로또번호와_중복되면_IllegalArgumentException() {
        // given
        int bonusNumber = 45;
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, bonusNumber);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers, bonusNumber));
    }

    @Test
    public void matchCount_구하기() {
        // given
        int bonusNumber = 45;
        int otherBonusNumber = 44;
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), bonusNumber);
        Lotto third = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), otherBonusNumber);

        // when
        int shouldBeSecondMatchCount = lotto.getMatchCounts(second);
        int shouldBeThirdMatchCount = lotto.getMatchCounts(third);

        // then
        assertThat(shouldBeSecondMatchCount).isEqualTo(LottoRank.SECOND.getMatchCount());
        assertThat(shouldBeThirdMatchCount).isEqualTo(LottoRank.THIRD.getMatchCount());
    }

    @Test
    public void 보너스_번호가_일치하는지_확인() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        int otherBonusNumber = 44;

        Lotto target = new Lotto(lottoNumbers, bonusNumber);
        Lotto same = new Lotto(lottoNumbers, bonusNumber);
        Lotto different = new Lotto(lottoNumbers, otherBonusNumber);

        // when
        boolean shouldBeTrue = target.isBonusNumberMatch(same);
        boolean shouldBeFalse = target.isBonusNumberMatch(different);

        // then
        assertThat(shouldBeTrue).isTrue();
        assertThat(shouldBeFalse).isFalse();
    }

    @Test
    public void 로또_결과_가져오기() {
        // given
        int bonusNumber = 45;
        int otherBonusNumber = 44;

        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto first = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), bonusNumber);
        Lotto second = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 16), otherBonusNumber);

        // when
        LottoMatchResult resultOfFirst = first.getResult(winner);
        LottoMatchResult resultOfSecond = second.getResult(winner);

        // then
        assertThat(resultOfFirst.getMatchCount()).isEqualTo(LottoRank.FIRST.getMatchCount());
        assertThat(resultOfFirst.isBonusNumberMatch()).isTrue();

        assertThat(resultOfSecond.getMatchCount()).isEqualTo(LottoRank.SECOND.getMatchCount());
        assertThat(resultOfSecond.isBonusNumberMatch()).isFalse();
    }
}
