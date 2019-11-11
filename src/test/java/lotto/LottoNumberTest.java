package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    void matchTest() {
        LottoNumber lottoNumber = new LottoNumber(5);

        assertThat(lottoNumber.hasMatchedNumber(createLottoNumbers(1, 2, 3, 4, 5, 6))).isTrue();
        assertThat(lottoNumber.hasMatchedNumber(createLottoNumbers(1, 2, 3, 4, 6, 7))).isFalse();
    }

    private static LottoNumbers createLottoNumbers(Integer ... numbers) {
        List<LottoNumber> lottoNumbers = Arrays
                .stream(numbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }
}
