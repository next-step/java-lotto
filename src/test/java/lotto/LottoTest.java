package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_번호중복예외발생() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);
        // when
        Lotto lotto = new FixedLottoGenerator(invalidNumbers).generateLotto();
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또생성_번호개수예외발생() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 7, 8, 2, 3, 4, 5);
        // when
        Lotto lotto = new FixedLottoGenerator(invalidNumbers).generateLotto();
        // then
    }

    @Test
    public void 로또2개_번호일치_3개() {
        // given
        List<Integer> currentLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> previousLottoNumbers = Arrays.asList(1, 3, 5, 7, 9, 11);
        Lotto currentLotto = new FixedLottoGenerator(currentLottoNumbers).generateLotto();
        Lotto previousLotto = new FixedLottoGenerator(previousLottoNumbers).generateLotto();
        // when
        int numberOfSame = currentLotto.countNumberOfMatch(previousLotto);
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
}
