/*
* 클래스 이름:
* 버전 정보:
* 날짜:
* 작성자: SunheeJo
 */

package lottopackage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("로또 구매 (자동)")
    public void lotto() {
        // given
        Lotto lotto = new Lotto();
        List<Integer> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumber.add(i);
        }

        // when, then
        int lottoLength = lotto.get().length;
        Assertions.assertThat(lottoLength).isEqaulTo(6);
        for (int i = 0; i < lotto.lottoLength; i++) {
            Assertions.assertThat(lottoNumber.contains( lotto.get().get(i) )).isEqaulTo(true);
        }
    }

    @Test
    @DisplayName("lotto.isMatch()")
    public void isMatch() {
        // given
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumber1st = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumber4th = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 7));
        List<Integer> winningNumber5th = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 7, 7));

        // when, then
        Assertions.assertThat(lotto.isMatch(winningNumber1st)).isEqualTo(1);
        Assertions.assertThat(lotto.isMatch(winningNumber3rd)).isEqualTo(3);
        Assertions.assertThat(lotto.isMatch(winningNumber4th)).isEqualTo(4);
        Assertions.assertThat(lotto.isMatch(winningNumber5th)).isEqualTo(5);
    }
}
