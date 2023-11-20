package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    @DisplayName("성공 - 로또가 생성된다.")
    void success_generate_lottos() {
        List<String> stringFormatManualLottos = List.of(
                "1, 2, 3, 4, 5, 6",
                "1, 2, 3, 4, 5, 7"
        );
        int autoLottoCount = 3;

        Lottos lottos = LottoFactory.generateLottos(stringFormatManualLottos, autoLottoCount);

        assertThat(lottos.getLottos()).hasSize(5);
    }

}