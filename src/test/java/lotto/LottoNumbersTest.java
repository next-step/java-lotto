package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("지난 주 당첨 번호를 입력 받는다.")
    void testLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers("14, 16, 21, 25, 38, 40");
        assertThat(lottoNumbers.getNumbers()).contains(
                new LottoNumber(14),
                new LottoNumber(16),
                new LottoNumber(21),
                new LottoNumber(25),
                new LottoNumber(38),
                new LottoNumber(40)
        );
    }
}
