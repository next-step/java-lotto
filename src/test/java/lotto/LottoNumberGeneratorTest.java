package lotto;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    void 로또번호를발행한다() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();

        Assertions.assertThat(lottoNumbers).hasSize(6);
    }

}
