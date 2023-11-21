package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.enumeration.LottoRank;
import step4.model.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinnerTest {

    @ParameterizedTest
    @CsvSource(value = {"18,19,20,21,22,23:5000", "1,24,25,26,27,28:5000", "1,2,19,20,21,25:50000"}, delimiter = ':')
    @DisplayName("당첨번호와 일치하는 숫자값에 해당하는 가격을 가져온다.")
    void getTotalPriceTest(String winnerNumber, int expectedPrice) {
        LottoWinner lottoWinner = new LottoWinner(List.of(new Lotto(new LottoNumbers(List.of(18,1,24,25,20,21)))), new LottoWinNumbers(winnerNumber), 45);
        Map<LottoRank, Integer> winnerBoard = lottoWinner.getWinnerNumberMatchCount();
        int totalPrice = lottoWinner.getTotalPrice(winnerBoard);

        assertThat(totalPrice).isEqualTo(expectedPrice);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIFTH", "1,2,3,17,6,9:FOURTH", "1,3,2,15,16,22:THIRD", "1,2,3,15,16,17:FIRST"}, delimiter = ':')
    @DisplayName("3개 이상 6개 이하 일치하는 숫자가 있다면 일치하는 갯수를 카운트한다.")
    void getWinnerScoreTest(String winnerNumbers, LottoRank expectedRank) {
        LottoWinner lottoWinner = new LottoWinner
                (List.of(new Lotto(new LottoNumbers(List.of(1,2,3,17,16,15)))), new LottoWinNumbers(winnerNumbers), 45);
        Map<LottoRank, Integer> winnerBoard = lottoWinner.getWinnerNumberMatchCount();

        assertThat(winnerBoard.get(expectedRank)).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"18,19,20,21,22,23:5.0", "1,24,25,21,27,20:1500.0", "1,2,19,20,21,25:50.0"}, delimiter = ':')
    @DisplayName("로또로 얻은 수익률을 계산한다.")
    void getRatingTest(String winnerNumber, Double rating) {
        LottoWinner lottoWinner = new LottoWinner(List.of(new Lotto(new LottoNumbers(List.of(18,1,24,25,20,21)))), new LottoWinNumbers(winnerNumber), 45);
        Map<LottoRank, Integer> winnerBoard = lottoWinner.getWinnerNumberMatchCount();
        lottoWinner.getTotalPrice(winnerBoard);

        assertThat(lottoWinner.getRating(1000, winnerBoard)).isEqualTo(rating);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "3,4,5,6,7,8:8", "43,42,41,30,21,20:43"}, delimiter = ':')
    @DisplayName("당첨번호에 포함된 보너스 번호가 넘어오면 예외를 발생시킨다.")
    void validateBonusNumberTest(String winNumbers, int bonusNumber) {
        assertThatThrownBy(() -> new LottoWinner(List.of(new Lotto(new LottoNumbers(List.of(18,1,24,25,20,21)))), new LottoWinNumbers(winNumbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호에 포함된 보너스 번호 입니다.");

    }
}
