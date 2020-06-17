package camp.nextstep.edu.nextstep8.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerNumberTest {
    @DisplayName("주어진 번호와 당첨 번호가 일치 하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,16:5",
            "1,2,3,4,15,16:4",
            "1,2,3,14,15,16:3",
            "1,2,13,14,15,16:2",
            "1,12,13,14,15,16:1",
            "11,12,13,14,15,16:0"
    }, delimiter = ':')
    public void matchCountTest(String lottoNumberStr, int expectMatchCount) {
        // given
        LottoWinnerNumber winnerNumber = new LottoWinnerNumber("1,2,3,4,5,6");
        LottoNumber lottoNumber = new LottoNumber(lottoNumberStr);

        // when
        int matchCount = winnerNumber.getMatchCount(lottoNumber);

        // then
        assertThat(matchCount).isEqualTo(expectMatchCount);
    }
}
