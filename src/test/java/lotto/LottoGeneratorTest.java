package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("6개의 숫자를 발행한다")
    @Test
    void generate_로또를발행한다() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();

        assertThat(lottoNumbers).hasSize(6);
    }
}
