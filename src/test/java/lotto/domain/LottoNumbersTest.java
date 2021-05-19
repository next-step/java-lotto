package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    private LottoNumber lottoNumber1;
    private LottoNumber lottoNumber2;
    private LottoNumber lottoNumber3;

    @BeforeEach
    void setUp() {
        lottoNumber1 = new LottoNumber(1);
        lottoNumber2 = new LottoNumber(2);
        lottoNumber3 = new LottoNumber(3);
    }

    @Test
    void create() {
        final List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
        );
        final LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        assertThat(lottoNumbers.getNumbers()).containsExactly(lottoNumber1, lottoNumber2, lottoNumber3);
    }
}
