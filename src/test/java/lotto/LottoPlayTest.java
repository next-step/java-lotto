package lotto;

import lotto.domain.Amount;
import lotto.domain.LottoPlay;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoPlayTest {

    @ParameterizedTest
    @CsvSource({"14000, 14"})
    @DisplayName("입력된 금액만큼의 해당하는 로또를 발급한다.")
    void generateLotto(int input, int countLotto) {
        LottoPlay lottoPlay = new LottoPlay();
        lottoPlay.createLotto(input);
        assertThat(lottoPlay.getLottoNumbers().size()).isEqualTo(countLotto);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,7,8,9:3", "1,2,3,4,7,8:4", "1,2,3,4,5,7:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    @DisplayName("당첨된 번호의 개수를 확인 할 수 있다.")
    void matchNumber3_Get5000(String input, int countWinnings) {
        String[] numbers = input.split(",");
        List<Integer> lottoNumber = new ArrayList<>();

        int[] winningNumbers = {1, 2, 3, 4, 5, 6};

        for (String number : numbers) {
            lottoNumber.add(Integer.parseInt(number));
        }

        LottoPlay lottoPlay = new LottoPlay();
        assertThat(lottoPlay.getMatchNumbers(lottoNumber, winningNumbers)).isEqualTo(countWinnings);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    @DisplayName("당첨 개수의 따라 금액이 달라진다.")
    void decisionMoneyByWinningNumbers(int matchNumbers, int amount) {
        assertThat(Amount.getWinningMoney(matchNumbers)).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,4:55000", "3,5:1505000"}, delimiter = ':')
    @DisplayName("당첨된 금액의 총 합을 구할 수 있다.")
    void canSumWinningAmount(String input, int totalAmount) {
        String[] matchNumbers = input.split(",");

        Winning winnings = new Winning();
        winnings.record(Integer.parseInt(matchNumbers[0]));
        winnings.record(Integer.parseInt(matchNumbers[1]));

        assertThat(winnings.getSumAmount()).isEqualTo(totalAmount);
    }

}
