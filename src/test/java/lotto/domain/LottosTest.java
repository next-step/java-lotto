package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    void lottosTest_generateLottos_자동_only() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.count()).isEqualTo(14);
    }

    @Test
    void lottosTest_generateLottos_자동_and_수동() {
        List<String> manualLottoNumbers =  new ArrayList<>(Arrays.asList(
                "8, 21, 23, 41, 42, 43"
                ,"3, 5, 11, 16, 32, 38"
                ,"7, 11, 16, 35, 36, 44"
        ));

        Lottos lottos = new Lottos(14000,manualLottoNumbers);

        assertThat(lottos.count()).isEqualTo(14);
    }
}