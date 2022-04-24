package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    void generateLotteries() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        assertThat(lottoGenerator.generateLotteries(3_000))
                .hasSize(3);
    }
}