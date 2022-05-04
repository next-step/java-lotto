package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호를 3개 추가 하면 수량은 3개이다.")
    void name() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.add(LottoGenerator.generate());
        lottoNumbers.add(LottoGenerator.generate());
        lottoNumbers.add(LottoGenerator.generate());
        assertThat(lottoNumbers.getQuantity()).isEqualTo(3);
    }

}
