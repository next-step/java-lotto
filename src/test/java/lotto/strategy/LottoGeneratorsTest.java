package lotto.strategy;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorsTest {

    @Test
    @DisplayName("성공 - LottoGenerators 객체가 생성된다.")
    void success_generate_lotto_generators() {
        List<String> stringFormatManualLottos = List.of(
                "1,2,3,4,5,6",
                "1,2,3,4,5,7"
        );
        int autoLottoCount = 3;

        LottoGenerators lottoGenerators = new LottoGenerators(stringFormatManualLottos, autoLottoCount);

        assertThat(lottoGenerators.getLottoGenerators()).hasSize(5);
    }

    @Test
    @DisplayName("성공 - 로또가 생성된다.")
    void success_generate_lottos() {
        List<String> stringFormatManualLottos = List.of(
                "1,2,3,4,5,6",
                "1,2,3,4,5,7"
        );
        int autoLottoCount = 3;

        LottoGenerators lottoGenerators = new LottoGenerators(stringFormatManualLottos, autoLottoCount);
        Lottos lottos = lottoGenerators.generateLottos();

        assertThat(lottos.getLottos()).hasSize(5);
    }

}