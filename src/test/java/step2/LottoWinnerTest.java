package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lotto;
import step2.model.LottoWinner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinnerTest {

    @ParameterizedTest
    @CsvSource(value = {"18,19,20,21,22,23:5000", "1,24,25,26,27,28:5000", "1,2,19,20,21,25:50000"}, delimiter = ':')
    @DisplayName("당첨번호와 일치하는 숫자값에 해당하는 가격을 가져온다.")
    void getTotalPriceTest(String winnerNumber, int expectedPrice) {
        LottoWinner lottoWinner = new LottoWinner(List.of(new Lotto(List.of(18,1,24,25,20,21))), winnerNumber);
        lottoWinner.getWinnerNumberMatchCount();
        int totalPrice = lottoWinner.getTotalPrice();

        assertThat(totalPrice).isEqualTo(expectedPrice);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:3", "1,2,3,17,6,9:4", "1,3,2,15,16,22:5", "1,2,3,15,16,17:6"}, delimiter = ':')
    @DisplayName("3개 이상 6개 이하 일치하는 숫자가 있다면 일치하는 갯수를 카운트한다.")
    void getWinnerScoreTest(String winnerNumbers, int expectedMatchCount) {
        LottoWinner lottoWinner = new LottoWinner(List.of(new Lotto(List.of(18,1,24,25,20,21))), winnerNumbers);
        Map<Integer, Long> winnerScore = lottoWinner.getWinnerNumberMatchCount();

        assertThat(winnerScore.get(expectedMatchCount)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"18,19,20,21,22,23", "1,24,25,26,27,28", "1,2,19,20,21,22"})
    @DisplayName("일치하는 숫자가 3개 미만이라면 아무것도 반환하지 않는다.")
    void getNoWinnerScoreTest(String winnerNumbers) {
        LottoWinner lottoWinner = new LottoWinner(List.of(new Lotto(List.of(1,2,3,15,16,17))), winnerNumbers);
        assertThat(lottoWinner.getWinnerNumberMatchCount()).isEmpty();
    }

    @ParameterizedTest
    @CsvSource(value = {"18,19,20,21,22,23:5.0", "1,24,25,21,27,20:1500.0", "1,2,19,20,21,25:50.0"}, delimiter = ':')
    @DisplayName("로또로 얻은 수익률을 계산한다.")
    void getRatingTest(String winnerNumber, Double rating) {
        LottoWinner lottoWinner = new LottoWinner(List.of(new Lotto(List.of(18,1,24,25,20,21))), winnerNumber);
        lottoWinner.getWinnerNumberMatchCount();
        lottoWinner.getTotalPrice();

        assertThat(lottoWinner.getRating(1000)).isEqualTo(rating);
    }
}
