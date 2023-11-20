package lotto.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ManualLottoGenerationTest {
    @Test
    @DisplayName("수동 로또가 입력한대로 생성되는지 확인")
    void 수동로또_생성_확인() {
        LottoGeneration lottoGeneration = new ManualLottoGeneration(Arrays.asList(1,2,3,4,5,6));

        Assertions.assertThat(lottoGeneration.generate()).isInstanceOf(Set.class);
    }
}
