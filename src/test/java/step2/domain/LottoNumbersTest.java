package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.LottoNumbers.getLottoNos;

class LottoNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {"1:7:6"}, delimiter = ':')
    public void 로또_자동생성(int start, int end, int size) {
        assertThat(getLottoNos(start, end).getLotteryInfo().size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:7:6"}, delimiter = ':')
    public void 로또_복수_게임_자동생성(int start, int end, int size) {
        assertThat(getLottoNos(start, end).getLotteryInfo().size()).isEqualTo(size);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,7,3:3"}, delimiter = ':')
    void getWinnersResultNo(String input, int result) {
        LottoNumbers lottoNumbers = LottoNumbers.convertStringToNo(input);
        assertThat(lottoNumbers.getLotteryInfo().size()).isEqualTo(result);
    }
}
