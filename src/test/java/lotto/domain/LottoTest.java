package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {
    @Test
    void checkValidLottoNumbersTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(lottoNumbers));
    }
}
