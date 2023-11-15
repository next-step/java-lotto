package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("구입 개수 n개 만큼 로또가 발급된다.")
    void generated_numbers_size() {
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();

        List<Lotto> lottos  = lottoNumberGenerator.generate(10);
        assertThat(lottos).hasSize(10);
    }
}
