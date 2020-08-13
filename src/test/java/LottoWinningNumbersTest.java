import domain.LottoNumbers;
import domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6=6", "2,3,4,5,6,7=5", "10,24,26,32,27,1=1"}, delimiter = '=')
    @DisplayName("한 로또 게임과 당첨 번호를 비교해 몇 개가 일치하는지 구한다.")
    void winningNumberTest(String input, int expected) {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);

        List<Integer> collect = makeInputToIntegerList(input);

        LottoNumbers lottoGame = new LottoNumbers(collect);

        int actual = lottoWinningNumbers.getWinningNumberInLottoGame(lottoGame);

        assertThat(actual).isEqualTo(expected);

    }

    private List<Integer> makeInputToIntegerList(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

}