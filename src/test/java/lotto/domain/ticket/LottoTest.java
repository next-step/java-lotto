package lotto.domain.ticket;

import lotto.enums.LottoRank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void 로또_생성_시_번호가_중복되면_IlligalArgumentException() {
        // given
        List<Integer> duplicatedNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);
        List<Integer> containsBonusNumbers = Arrays.asList(1, 2, 3, 4, 5, 45);
        int bonusNumber = 45;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(duplicatedNumbers, bonusNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(containsBonusNumbers, bonusNumber));
    }

    @Test
    public void 로또_생성_시_숫자가_6개가_아니면_IlligalArgumentException() {
        // given
        List<Integer> fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> sevenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int bonusNumber = 45;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(fiveNumbers, bonusNumber));
        new Lotto(sixNumbers, bonusNumber);
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(sevenNumbers, bonusNumber));
    }

    @Test
    public void 로또_생성_시_숫자가_범위를_벗어나면_IlligalArgumentException() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int outOfMaxNumber = Lotto.MAX_NUMBER + 1;
        int outOfMinNumber = Lotto.MIN_NUMBER - 1;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers, outOfMaxNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers, outOfMinNumber));
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
        boolean shouldBeTrue = target.isBonusNumberSame(same);
        boolean shouldBeFalse = target.isBonusNumberSame(different);

        // then
        assertThat(shouldBeTrue).isTrue();
        assertThat(shouldBeFalse).isFalse();
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
}
