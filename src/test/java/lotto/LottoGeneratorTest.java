package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {


    @Test
    public void generate() {
        LottoNumbers generate = LottoGenerator.generate();
        assertThat(generate.size()).isEqualTo(6);
    }

}
