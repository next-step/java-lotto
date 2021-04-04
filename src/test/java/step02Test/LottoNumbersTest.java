package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.InputNumberRule;
import step02.LottoNumbers;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("매징되는 숫자 카운트 테스트")
    void compareMathNumber() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44"));
        assertThat(lottoNumbers.countCompareMathNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")))).isEqualTo(6);
    }
}
