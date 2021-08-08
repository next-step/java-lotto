package lotto;

import lotto.model.LottoNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNumbersTest {
    private static final int LOTTO_NUMBER_LENGTH = 6;

    @Test
    void 로또_6개숫자_자동생성() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.generateNumbers();
        assertThat(lottoNumbers.selectedNumber().size()).isEqualTo(LOTTO_NUMBER_LENGTH);
    }


}
