package lotto.domain;

import lotto.util.LottoGenerator;
import lotto.util.ManualLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoTest {
    @Test
    void getCountByMatch() {
        LottoGenerator lottoGenerator = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoGenerator lottoGenerator2 = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(new Lotto(lottoGenerator).getCountByMatch(new Lotto(lottoGenerator2)))
                .isEqualTo(6);

    }
}