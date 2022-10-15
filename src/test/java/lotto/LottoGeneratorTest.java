package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    void 로또번호를발행한다() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();

        assertThat(lottoNumbers).hasSize(6);
    }
}
