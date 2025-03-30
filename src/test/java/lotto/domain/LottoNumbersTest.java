package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoRank.MATCH_3;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LottoNumbersTest {

    @Test
    public void 로또번호_6개생성_테스트() {
        LottoNumbers ln = new LottoNumbers();
        assertThat(ln.numbers()).hasSize(6);
    }

    @Test
    public void 로또번호_정답당첨_테스트() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers ln = new LottoNumbers(numbers);

        LottoNumbers lottoWinningNumbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(ln.lottoRank(lottoWinningNumbers)).isEqualTo(MATCH_3);
    }

    @Test
    public void 로또번호_정렬테스트() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(6, 5, 3, 4, 2, 1));
        LottoNumbers ln = new LottoNumbers(numbers);

        LottoNumbers lottoWinningNumbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertArrayEquals(ln.numbers().toArray(), lottoWinningNumbers.numbers().toArray());
    }
}
