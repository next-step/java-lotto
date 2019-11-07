package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.data.LottoNumbers;

public class LottoTest {
    private Lotto lotto;

    @Test
    void validate_match_count() {
        LottoNumbers numbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers numbers2 = new LottoNumbers(Arrays.asList(12, 22, 32, 42, 52, 62));
        lotto = new Lotto(numbers);

        assertThat(lotto.matchCount(numbers)).isEqualTo(6);
        assertThat(lotto.matchCount(numbers2)).isEqualTo(0);
    }
}
