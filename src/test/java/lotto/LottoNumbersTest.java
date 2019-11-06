package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.data.LottoNumbers;

public class LottoNumbersTest {
    private LottoNumbers lottoNumbers;

    @Test
    void validate_match_count() {
        lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers win = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lose = new LottoNumbers(Arrays.asList(11, 12, 13, 14, 15, 16));

        assertThat(lottoNumbers.matchCount(win)).isEqualTo(6);
        assertThat(lottoNumbers.matchCount(lose)).isEqualTo(0);
    }
}
