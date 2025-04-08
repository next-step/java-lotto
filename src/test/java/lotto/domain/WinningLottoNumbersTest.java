package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WinningLottoNumbersTest {

    @Test
    public void 로또번호_정답당첨_숫자3개일치_보너스불일치() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(13);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(
                LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 10, 11, 12)),
                bonusNumber);

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_3);
    }

    @Test
    public void 로또번호_정답당첨_숫자3개일치_보너스번호일치() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(
                LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 10, 11, 12)),
                bonusNumber);

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_3);
    }

    @Test
    public void 로또번호_정답당첨_숫자4개일치_보너스불일치() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(13);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(
                LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 11, 12)),
                bonusNumber);

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_4);
    }

    @Test
    public void 로또번호_정답당첨_숫자4개일치_보너스번호일치() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(
                LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 11, 12)),
                bonusNumber);

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_4);
    }

    @Test
    public void 로또번호_정답당첨_숫자5개일치_보너스불일치() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(13);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(
                LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 12)),
                bonusNumber);

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_5);
    }

    @Test
    public void 로또번호_정답당첨_2등_당첨() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(
                LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 12)),
                bonusNumber);

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_5_AND_BONUS);
    }

    @Test
    public void 로또번호_정답당첨_1등_당첨() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLottoNumbers winningNumbers = new WinningLottoNumbers(
                LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                bonusNumber);

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_6);
    }
}
