package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("개수를 입력하면 로또번호 6개가 그 개수만큼 나온다")
    @Test
    void number_of_lotto() {
        LottoGenerator lottoGenerator = new LottoGenerator(14);

        assertThat(lottoGenerator.getLottoNumberGenerators().size()).isEqualTo(14);
    }

}
