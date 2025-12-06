package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGeneratorTest {

    @Test
    @DisplayName("돈을 입력하여 자동으로 몇장 살 수 있는지")
    void AutoGenerator() {
        LottoGenerator autoLottoGenerator =  new AutoLottoGenerator(14000);

        Assertions.assertThat(autoLottoGenerator.generate()).hasSize(14);
    }

    @Test
    @DisplayName("돈을 입력하여 자동과 수동으로 몇장 살 수 있는지")
    void mixGenerator() {
        LottoGenerator mixedLottoGenerator = new LottosBundleGenerator(
                new LottoPurChase(3000, 2, 1), List.of("1, 2, 3, 4, 5, 6")
        );

        Assertions.assertThat(mixedLottoGenerator.generate()).hasSize(3);
    }
}
