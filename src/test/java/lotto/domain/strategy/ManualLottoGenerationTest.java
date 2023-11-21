package lotto.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoGenerationTest {
    @Test
    @DisplayName("수동 로또가 입력한대로 생성되는지 확인")
    void 수동로또_생성_확인() {
        LottoGeneration lottoGeneration = new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoGeneration.generate()).isInstanceOf(Set.class);
    }
}
