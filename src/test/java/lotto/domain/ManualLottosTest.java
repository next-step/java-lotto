package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottosTest {

    @Test
    void 수동_로또_리스트로_생성한다() {
        Lotto lotto1 = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = new Lotto(7, 8, 9, 10, 11, 12);
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2);

        ManualLottos manualLottos = new ManualLottos(lottos);

        assertThat(manualLottos.getCount()).isEqualTo(2);
    }

    @Test
    void 비어있거나_null_입력시_빈_리스트로_초기화() {
        ManualLottos manualLottos = new ManualLottos(null);
        ManualLottos emptyManualLottos = new ManualLottos(Collections.emptyList());

        assertThat(manualLottos.getCount()).isEqualTo(0);
        assertThat(emptyManualLottos.getCount()).isEqualTo(0);
    }

}
