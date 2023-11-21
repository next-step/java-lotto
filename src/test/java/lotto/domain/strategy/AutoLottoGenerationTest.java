package lotto.domain.strategy;

import lotto.domain.LottoNumberCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGenerationTest {
    @Test
    @DisplayName("자동 로또가 6자리 생성되는지 확인")
    void 자동로또_생성_확인() {
        AutoLottoGeneration autoLottoGeneration = new AutoLottoGeneration(LottoNumberCache.values());

        assertThat(autoLottoGeneration.generate().size()).isEqualTo(6);
    }
}
