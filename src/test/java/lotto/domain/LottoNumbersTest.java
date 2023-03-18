package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumbersTest {

    @Test
    void 로또_번호는_중복이_올_수_없다() {
        List<Integer> lottoNum = Arrays.asList(11, 13, 13, 26, 43, 1);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumbers(lottoNum));
    }
}