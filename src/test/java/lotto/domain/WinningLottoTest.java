package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private static final Lotto testLotto;
    private static final LottoNumber bonus = LottoNumber.from(7);
    private static final WinningLotto testWinningLotto;

    static {
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        testLotto = Lotto.from(testNumbers);
        testWinningLotto = new WinningLotto(testLotto, bonus);
    }


    @DisplayName("당첨 번호와 보너스 번호는 중복될 수 없다")
    @Test
    void 번호_중복_확인() {
        LottoNumber bonusNumber = LottoNumber.from(1);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningLotto(testLotto, bonusNumber));
    }

    @DisplayName("주어진 로또 객체에 당첨 번호가 몇개 있는지 반환한다")
    @Test
    void 당첨_번호_반환() {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 8, 9, 10);
        Lotto userLotto = Lotto.from(userNumbers);
        int actual = testWinningLotto.getMatchCount(userLotto);
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("보너스 번호와 일치하는 로또 숫자가 있는지 반환한다")
    @Test
    void 보너스_번호가_있는_경우() {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto userLotto = Lotto.from(userNumbers);
        boolean actual = testWinningLotto.getMatchBonus(userLotto);
        assertThat(actual).isTrue();
    }

    @DisplayName("보너스 번호와 일치하는 로또 숫자가 있는지 반환한다")
    @Test
    void 보너스_번호가_없는_경우() {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 8);
        Lotto userLotto = Lotto.from(userNumbers);
        boolean actual = testWinningLotto.getMatchBonus(userLotto);
        assertThat(actual).isFalse();
    }
}
