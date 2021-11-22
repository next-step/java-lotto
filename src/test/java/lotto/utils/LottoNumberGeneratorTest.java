package lotto.utils;

import lotto.domain.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @DisplayName("6개의 로또 번호를 생성한다.")
    @Test
    void generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

}
