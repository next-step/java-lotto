package autolotto.domain;

import autolotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void generateRequestGiven_ReturnLottoNumber() {
        Set<Integer> randoms = new LottoGenerator().generate();
        assertThat(randoms.size()).isEqualTo(6);
    }
}
