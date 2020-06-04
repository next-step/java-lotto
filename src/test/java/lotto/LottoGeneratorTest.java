package lotto;

import lotto.model.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("로또 번호 생성트기 테스")
    @Test
    void LOTTO_NUMBER_GENERATOR_TEST() {
        assertThat(LottoNumberGenerator.getNumber()).hasSize(6);
    }
}
