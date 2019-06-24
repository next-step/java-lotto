package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGeneratorTest {

    @Test
    void lottoGenerationRandom() {
        LottoGeneratorRandom lottoGenerator = new LottoGeneratorRandom();
        List<Integer> result =lottoGenerator.lottoGeneration();
        assertThat(result.size()).isEqualTo(6);
    }
}