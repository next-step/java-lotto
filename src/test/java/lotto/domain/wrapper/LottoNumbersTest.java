package lotto.domain.wrapper;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumbersTest {

    @Test
    void sort_Test() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(6,5,4,3,2,1));

        assertThat(lottoNumbers.equals(new LottoNumbers(Arrays.asList(1,2,3,4,5,6))));
    }
}
