package autolotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void generateRequestGiven_ReturnLottoNumber() {
        Set<Integer> randoms = LottoGenerator.generate();
        assertThat(randoms.size()).isEqualTo(6);
    }
}
