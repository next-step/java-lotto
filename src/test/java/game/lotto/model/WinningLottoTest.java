package game.lotto.model;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호에_보너스번호_포함() {
        final LottoNumber bonus = new LottoNumber(6);
        final String stringNumbers = "1,2,3,4,5,6";
        Lotto lotto = createLotto(stringNumbers);

        new WinningLotto(lotto, bonus);
    }

    @Test
    public void 매치_테스트_3등() {
        final LottoNumber bonus = new LottoNumber(8);
        final String stringNumber = "1,2,3,4,5,6";
        final Lotto lotto = createLotto(stringNumber);

        final String winningNumbers = "1,2,3,4,5,7";
        WinningLotto winningLotto = new WinningLotto(createLotto(winningNumbers), bonus);

        Match match = winningLotto.match(lotto);

        assertThat(match.getRank()).isEqualByComparingTo(Rank.THIRD);
        assertThat(lotto.contains(bonus)).isFalse();
    }

    @Test
    public void 매치_테스트_2등() {
        final LottoNumber bonus = new LottoNumber(6);
        final String stringNumber = "1,2,3,4,5,6";
        final Lotto lotto = createLotto(stringNumber);

        final String winningNumbers = "1,2,3,4,5,7";
        WinningLotto winningLotto = new WinningLotto(createLotto(winningNumbers), bonus);

        Match match = winningLotto.match(lotto);

        assertThat(match.getRank()).isEqualByComparingTo(Rank.SECOND);
        assertThat(lotto.contains(bonus)).isTrue();
    }

    private Lotto createLotto(String stringNumbers) {
        Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        return new Lotto(lottoNumbers);
    }

}