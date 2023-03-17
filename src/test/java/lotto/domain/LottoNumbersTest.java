package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    void 로또_번호_중복이_없음() {
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 6, 4, 6);
        assertThatExceptionOfType(IllegalAccessError.class)
                .isThrownBy(() -> new LottoNumbers(lottoNum));
    }

    @Test
    void 로또_번호는_6자리() {
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 6, 42, 5, 6);
        assertThatExceptionOfType(IllegalAccessError.class)
                .isThrownBy(() -> new LottoNumbers(lottoNum));
    }

}