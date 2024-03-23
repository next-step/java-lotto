package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    void count_match() {
        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> winngingNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.countMatchingWith(winngingNumbers)).isEqualTo(6);
    }

}
