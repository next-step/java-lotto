package lotto.strategy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomGeneratorTest {

    @Test
    void generateTest() {
        LottoGenerator lottoGenerator = new LottoRandomGenerator();
        List<Integer> lotto = lottoGenerator.generate();
        assertThat(lotto.size()).isEqualTo(6);
    }
}