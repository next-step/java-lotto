package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_번호중복예외발생() {
        // given
        String invalidNumbers = "1, 1, 2, 3, 4, 5";
        // when
        Lotto lotto = LottoGenerator.generateLotto(invalidNumbers);
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_번호개수예외발생() {
        // given
        String invalidNumbers = "1, 7, 8, 2, 3, 4, 5";
        // when
        Lotto lotto = LottoGenerator.generateLotto(invalidNumbers);
        // then
    }

    @Test
    public void 로또2개_번호일치_3개() {
        // given
        String currentLottoNumbers = "1, 2, 3, 4, 5, 6";
        String previousLottoNumbers = "1, 3, 5, 7, 9, 11";
        Lotto currentLotto = LottoGenerator.generateLotto(currentLottoNumbers);
        WinningLotto previousLotto = LottoGenerator.generateWinningLotto(previousLottoNumbers, 12);
        // when
        int numberOfSame = previousLotto.countNumberOfMatch(currentLotto);
        // then
        assertThat(numberOfSame).isEqualTo(3);
    }

    @Test
    public void 로또랜덤생성() {
        // given
        // when
        Lottos purchaseHistory = new AutoLottoGenerator(3).generateLottos();
        System.out.println(purchaseHistory.getLottos());
        // then
    }

    @Test
    public void 로또2개_번호일치5개와_보너스볼일치() {
        // given
        String currentLottoNumbers = "1, 2, 3, 4, 5, 6";
        String previousLottoNumbers = "1, 2, 3, 4, 5, 7";
        int bonusNumber = 6;
        Lotto currentLotto = LottoGenerator.generateLotto(currentLottoNumbers);
        WinningLotto previousLotto = LottoGenerator.generateWinningLotto(previousLottoNumbers, bonusNumber);
        // when
        int numberOfSame = previousLotto.countNumberOfMatch(currentLotto);
        boolean isMatchingBonus = previousLotto.isAnyMatchingBonusBall(currentLotto);
        // then
        assertThat(numberOfSame).isEqualTo(5);
        assertThat(isMatchingBonus).isTrue();
    }
}
