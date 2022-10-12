package lotto.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    void When_GenerateLotto_Then_Success() {
        LottoGenerator lottoGenerator = new LottoGenerator();

        assertThatNoException().isThrownBy(() -> lottoGenerator.generate());
    }
}
