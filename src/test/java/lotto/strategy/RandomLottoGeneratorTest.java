package lotto.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoGeneratorTest {

    @Test
    @DisplayName("하나의 로또에는 총 6개의 숫자가 존재한다.")
    void success_lotto_numbers_size() {
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        assertThat(lottoGenerator.lotto()).hasSize(6);
    }

}
