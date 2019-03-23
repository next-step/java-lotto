package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_번호중복예외발생() {
        // given
        String invalidNumbers = "1, 1, 2, 3, 4, 5";
        // when
        Lotto lotto = new FixedLottoGenerator(invalidNumbers).generateLotto();
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_번호개수예외발생() {
        // given
        String invalidNumbers = "1, 7, 8, 2, 3, 4, 5";
        // when
        Lotto lotto = new FixedLottoGenerator(invalidNumbers).generateLotto();
        // then
    }

    @Test
    public void 로또2개_번호일치_3개() {
        // given
        String currentLottoNumbers = "1, 2, 3, 4, 5, 6";
        String previousLottoNumbers = "1, 3, 5, 7, 9, 11";
        Lotto currentLotto = new FixedLottoGenerator(currentLottoNumbers).generateLotto();
        WinningLotto previousLotto = new FixedLottoGenerator(previousLottoNumbers).generateWinningLotto();
        // when
        int numberOfSame = previousLotto.countNumberOfMatch(currentLotto);
        // then
        assertThat(numberOfSame).isEqualTo(3);
    }

    @Test
    public void 로또랜덤생성() {
        // given
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        // when
        PurchaseHistory purchaseHistory = new PurchaseHistory(3000, randomLottoGenerator);
        System.out.println(purchaseHistory.getLottos());
        // then
    }

    @Test
    public void 로또2개_번호일치5개와_보너스볼일치() {
        // given
        String currentLottoNumbers = "1, 2, 3, 4, 5, 6";
        String previousLottoNumbers = "1, 2, 3, 4, 5, 7";
        int bonusNumber = 6;
        Lotto currentLotto = new FixedLottoGenerator(currentLottoNumbers).generateLotto();
        WinningLotto previousLotto = new FixedLottoGenerator(previousLottoNumbers, bonusNumber).generateWinningLotto();
        // when
        int numberOfSame = previousLotto.countNumberOfMatch(currentLotto);
        boolean isMatchingBonus = previousLotto.isAnyMatchingBonusBall(currentLotto);
        // then
        assertThat(numberOfSame).isEqualTo(5);
        assertThat(isMatchingBonus).isTrue();
    }
}
