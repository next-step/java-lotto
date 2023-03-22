package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.*;

class LottoNumbersTest {

    @Test
    void 로또_번호_중복_발생_확인() {

        Set<LottoNumber> lottoNumber = new HashSet<>();
        for(int i : Arrays.asList(11, 13, 15, 26, 42, 13))
        {
            lottoNumber.add(new LottoNumber(i));
        }
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(lottoNumber));
    }
}