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
    public void WinningLottoNumbers_parsingInputString_검증() {

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();
        LottoNumbers lottoNumbers = winningLottoNumbers.parsingInputString("1,2,3,4,5,6");

        assertThat(lottoNumbers.contains(1)).isTrue();
        assertThat(lottoNumbers.contains(2)).isTrue();
        assertThat(lottoNumbers.contains(3)).isTrue();
        assertThat(lottoNumbers.contains(4)).isTrue();
        assertThat(lottoNumbers.contains(5)).isTrue();
        assertThat(lottoNumbers.contains(6)).isTrue();
    }

    @Test
    public void matchLottoNumbers_당첨번호비교결과값검증() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,14,15,16", "7");
        int[] numbers = {1,2,3,4,5,6};
        LottoNumbers lottoNumbers = LottoNumbers.generateManualOf(numbers);

        MatchStatusOfALotto matchStatusOfALotto = new MatchStatusOfALotto(3, false);
        assertThat(winningLottoNumbers.matchLottoNumbers(lottoNumbers)).isEqualTo(matchStatusOfALotto);
    }


}
