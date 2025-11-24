package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottosTest {

    @Test
    void 수동_로또_문자열리스트로_생성한다() {
        List<String> lottosInputs = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");

        ManualLottos manualLottos = new ManualLottos(lottosInputs);

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
