package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    void count_match() {
        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertThat(lottoNumbers.countMatchingWith(new BonusBall(7))).isEqualTo(1);
    }

}
