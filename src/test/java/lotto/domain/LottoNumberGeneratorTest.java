package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @DisplayName("임의의 로또 번호 6개를 가져온다.")
    @Test
    void generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}