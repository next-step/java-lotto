package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WinningLottoNumbersTest {

    @Test
    public void 로또번호_정답당첨_테스트() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLottoNumbers winningNumbers = WinningLottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 10, 11, 12, 13));

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_3);
    }

    @Test
    public void 로또번호_5개_일치_테스트() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLottoNumbers winningNumbers = WinningLottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 12, 13));

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_5);
    }

    @Test
    public void 로또번호_2등_당첨_테스트() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLottoNumbers winningNumbers = WinningLottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 12, 6));

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_5_AND_BONUS);
    }

    @Test
    public void 로또번호_1등_당첨_테스트() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));

        WinningLottoNumbers winningNumbers = WinningLottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThat(winningNumbers.lottoRank(numbers)).isEqualTo(MATCH_6);
    }
}
