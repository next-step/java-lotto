package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    void 로또번호를발행한다() {
        int[] lottoNumbers = LottoNumberGenerator.generate();

        Assertions.assertThat(lottoNumbers).hasSize(6);
    }

}
