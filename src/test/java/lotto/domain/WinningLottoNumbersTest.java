package lotto.domain;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoNumbersTest {

    @Test
    public void WinningLottoNumbers_당첨번호객체생성검증() {

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,22,33,4,5,6,", "7");

        assertThat(winningLottoNumbers.containsMain(1)).isTrue();
        assertThat(winningLottoNumbers.containsMain(22)).isTrue();
        assertThat(winningLottoNumbers.containsMain(33)).isTrue();
        assertThat(winningLottoNumbers.containsMain(4)).isTrue();
        assertThat(winningLottoNumbers.containsMain(5)).isTrue();
        assertThat(winningLottoNumbers.containsMain(6)).isTrue();

        assertThat(winningLottoNumbers.containsBonus(7)).isTrue();
    }

    @Test
    public void matchLottoNumbers_당첨번호비교결과값검증() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6","7");
        int[] numbers = {1,2,3,4,5,7};
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        MatchStatusOfALotto matchStatusOfALotto = new MatchStatusOfALotto(5, true);
        assertThat(winningLottoNumbers.matchLottoNumbers(lottoNumbers)).isEqualTo(matchStatusOfALotto);
    }
}
