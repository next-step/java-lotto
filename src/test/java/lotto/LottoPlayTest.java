package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

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
        assertThat(lottoPlay.getWinningNumbers(lottoNumber, winningNumbers)).isEqualTo(countWinnings);
    }
}
