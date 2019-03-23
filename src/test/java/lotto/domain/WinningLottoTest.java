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
    public void matchCount_구하기() {
        // given
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(45));

        Lotto six = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto five = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 16));
        Lotto two = new Lotto(getLottoNumbers(1, 2, 13, 14, 15, 16));

        // when
        int shouldBeSix = winningLotto.getMatchCounts(six);
        int shouldBeFive = winningLotto.getMatchCounts(five);
        int shouldBeTwo = winningLotto.getMatchCounts(two);

        // then
        assertThat(shouldBeSix).isEqualTo(6);
        assertThat(shouldBeFive).isEqualTo(5);
        assertThat(shouldBeTwo).isEqualTo(2);
    }

    @Test
    public void 보너스_번호가_일치하는지_확인() {
        // given
        int bonusNumber = 45;
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(bonusNumber));

        Lotto same = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, bonusNumber));
        Lotto different = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));

        // when
        boolean shouldBeTrue = winningLotto.isBonusNumberMatch(same);
        boolean shouldBeFalse = winningLotto.isBonusNumberMatch(different);

        // then
        assertThat(shouldBeTrue).isTrue();
        assertThat(shouldBeFalse).isFalse();
    }

    @Test
    public void 로또_결과_가져오기() {
        // given
        int bonusNumber = 45;
        WinningLotto winningLotto = new WinningLotto(getLottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.getInstance(bonusNumber));

        Lotto first = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, bonusNumber));

        // when
        LottoMatchResult resultOfFirst = winningLotto.getMatchResult(first);
        LottoMatchResult resultOfSecond = winningLotto.getMatchResult(second);

        // then
        assertThat(LottoRank.getRankOf(resultOfFirst)).isEqualByComparingTo(LottoRank.FIRST);
        assertThat(LottoRank.getRankOf(resultOfSecond)).isEqualByComparingTo(LottoRank.SECOND);
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}
