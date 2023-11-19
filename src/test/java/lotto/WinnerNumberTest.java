package lotto;

import lotto.domain.WinnerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1"}, delimiter = ':')
    @DisplayName("사용자가 입력한 하나의 숫자와 당첨 숫자를 비교하고 결괏값에 따라 TRUE / FALSE를 리턴한다")
    void 한자리_숫자를_비교하고_당첨_숫자와_같으면_TRUE를_리턴한다(String value, String expected) {
        WinnerNumber winnerNumber = new WinnerNumber();

        boolean result = winnerNumber.compare(value,expected);

        assertThat(result).isTrue();
    }
}
