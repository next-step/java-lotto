package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Numbers.getLottoNos;

class NumbersTest {

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
        Numbers numbers = Numbers.convertStringToNo(input);
        assertThat(numbers.getLotteryInfo().size()).isEqualTo(result);
    }
}
