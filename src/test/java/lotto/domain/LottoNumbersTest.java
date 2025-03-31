package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호 6개를 생성한다.")
    void generate() {
        List<LottoNumber> lottoNumbers = LottoNumbers.generate();
        Assertions.assertThat(lottoNumbers).hasSize(Lotto.NUMBER_COUNT);
    }
}
