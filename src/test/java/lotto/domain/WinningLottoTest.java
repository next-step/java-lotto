package lotto.domain;

import lotto.enums.LottoRank;
import lotto.vo.LottoMatchResult;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {
    @Test
    public void 생성_시_보너스_번호가_로또번호와_중복되면_IllegalArgumentException() {
        // given
        int bonusNumber = 45;
        List<LottoNumber> lottoNumbers = getLottoNumbers(1, 2, 3, 4, 5, bonusNumber);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(lottoNumbers, LottoNumber.getInstance(bonusNumber)));
    }

    @Test
    public void matchCount_구하기_모든_로또_번호가_겹치는_경우() {
        // given
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(45));
        Lotto lotto = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));

        // when
        int shouldBeSix = winningLotto.getMatchCounts(lotto);

        // then
        assertThat(shouldBeSix).isEqualTo(6);
    }

    @Test
    public void matchCount_구하기_모든_로또_번호가_겹치지_않는_경우() {
        // given
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(45));
        Lotto lotto = new Lotto(getLottoNumbers(11, 12, 13, 14, 15, 16));

        // when
        int shouldBeZero = winningLotto.getMatchCounts(lotto);

        // then
        assertThat(shouldBeZero).isEqualTo(0);
    }

    @Test
    public void 보너스_번호가_일치하는지_확인() {
        // given
        int bonusNumber = 45;
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(bonusNumber));
        Lotto lotto  = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, bonusNumber));

        // when
        boolean shouldBeTrue = winningLotto.isBonusNumberMatch(lotto);

        // then
        assertThat(shouldBeTrue).isTrue();
    }

    @Test
    public void 보너스_번호가_불일치하는지_확인() {
        // given
        int bonusNumber = 45;
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(bonusNumber));
        Lotto lotto = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));

        // when
        boolean shouldBeFalse = winningLotto.isBonusNumberMatch(lotto);

        // then
        assertThat(shouldBeFalse).isFalse();
    }

    @Test
    public void 로또_결과_가져오기_2등() {
        // given
        int bonusNumber = 45;
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(bonusNumber));

        Lotto second = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, bonusNumber));

        // when
        LottoMatchResult resultOfSecond = winningLotto.getMatchResult(second);

        // then
        assertThat(LottoRank.getRankOf(resultOfSecond)).isEqualByComparingTo(LottoRank.SECOND);
    }

    @Test
    public void 로또_결과_가져오기_3등() {
        // given
        int bonusNumber = 45;
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(bonusNumber));

        Lotto third = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 16));


        // when
        LottoMatchResult resultOfThird = winningLotto.getMatchResult(third);

        // then
        assertThat(LottoRank.getRankOf(resultOfThird)).isEqualByComparingTo(LottoRank.THIRD);
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}
