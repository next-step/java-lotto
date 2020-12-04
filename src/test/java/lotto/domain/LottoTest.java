package lotto.domain;

import lotto.util.LottoGenerator;
import lotto.util.ManualLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class LottoTest {
    @Test
    void getCountByMatch() {
        LottoGenerator lottoGenerator = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoGenerator lottoGenerator2 = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(new Lotto(lottoGenerator).getCountByMatch(new Lotto(lottoGenerator2)))
                .isEqualTo(6);

    }

    @ParameterizedTest
    @CsvSource(value = {"1/true", "10/false", "2/true", "20/false"}, delimiter = '/')
    void isBonus(int argBonusBall, boolean argResult) {
        LottoGenerator lottoGenerator = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(new Lotto(lottoGenerator).
                isBonus(new LottoNumber(argBonusBall)))
                .isEqualTo(argResult);
    }
}