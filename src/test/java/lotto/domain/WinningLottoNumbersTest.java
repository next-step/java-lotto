package lotto.domain;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoNumbersTest {

    @Test
    public void WinningLottoNumbers_당첨번호객체생성검증() {

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,22,33,4,5,6,", "7");

        assertThat(winningLottoNumbers.containsMain(new LottoNo(1))).isTrue();
        assertThat(winningLottoNumbers.containsMain(new LottoNo(22))).isTrue();
        assertThat(winningLottoNumbers.containsMain(new LottoNo(33))).isTrue();
        assertThat(winningLottoNumbers.containsMain(new LottoNo(4))).isTrue();
        assertThat(winningLottoNumbers.containsMain(new LottoNo(5))).isTrue();
        assertThat(winningLottoNumbers.containsMain(new LottoNo(6))).isTrue();

        assertThat(winningLottoNumbers.containsBonus(new LottoNo(7))).isTrue();
    }

    @Test
    public void WinningLottoNumbers_parsingInputString_검증() {

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();
        LottoNumbers lottoNumbers = winningLottoNumbers.parsingInputString("1,2,3,4,5,6");

        assertThat(lottoNumbers.contains(new LottoNo(1))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNo(2))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNo(3))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNo(4))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNo(5))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNo(6))).isTrue();
    }

    @Test
    public void matchLottoNumbers_당첨번호비교결과값검증() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,14,15,16", "7");
        int[] numbers = {1,2,3,4,5,6};
        LottoNumbers lottoNumbers = LottoNumbers.generateManualOf(numbers);

        MatchStatusOfALotto matchStatusOfALotto = new MatchStatusOfALotto(3, false);
        assertThat(winningLottoNumbers.matchLottoNumbers(lottoNumbers)).isEqualTo(matchStatusOfALotto);
    }

    @Test
    public void containsMain_검증() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", "11");
        assertThat(winningLottoNumbers.containsMain(new LottoNo(1))).isTrue();
        assertThat(winningLottoNumbers.containsMain(new LottoNo(11))).isFalse();
    }

    @Test
    public void containsBonus_검증() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", "11");
        assertThat(winningLottoNumbers.containsBonus(new LottoNo(1))).isFalse();
        assertThat(winningLottoNumbers.containsBonus(new LottoNo(11))).isTrue();
    }

}
