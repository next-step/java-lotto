package lotto.strategy;

import lotto.LottoNumberCache;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoLottoGenerationTest {
    @Test
    @DisplayName("자동 로또가 6자리 생성되는지 확인")
    void 자동로또_생성_확인() {
        AutoLottoGeneration autoLottoGeneration = new AutoLottoGeneration(LottoNumberCache.values());

        Assertions.assertThat(autoLottoGeneration.generate().size()).isEqualTo(6);
    }
}
