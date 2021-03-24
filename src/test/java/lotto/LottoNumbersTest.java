package lotto;

import lotto.domain.LottoNumbers;
import lotto.dto.LottoNumber;
import lotto.dto.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    @DisplayName("하나의 로또에 중복되는 숫자가 있으면 에러가 발생한다.")
    void lottoNumberUniqueInLotto() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 5);
        List<LottoNumber> lotto = new ArrayList<>();

        for (Integer number : lottoNumber) {
            lotto.add(new LottoNumber(number));
        }

        assertThatThrownBy(() -> {
            new LottoNumbers(lotto);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("하나의 로또의 숫자가 6개가 아닌 경우 에러가 발생한다.")
    void oneLotto_6() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5);
        List<LottoNumber> lotto = new ArrayList<>();

        for (Integer number : lottoNumber) {
            lotto.add(new LottoNumber(number));
        }

        assertThatThrownBy(() -> {
            new LottoNumbers(lotto);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,7,8,9:3", "1,2,3,4,7,8:4", "1,2,3,4,5,7:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    @DisplayName("당첨된 번호의 개수를 확인 할 수 있다.")
    void matchNumberCount(String input, int countWinnings) {
        String[] numbers = input.split(",");
        List<LottoNumber> lottoNumber = new ArrayList<>();

        List<Integer> winningNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            winningNumber.add(i);
        }

        for (String number : numbers) {
            lottoNumber.add(new LottoNumber(Integer.parseInt(number)));
        }

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumber);
        assertThat(lottoNumbers.countMatchNumber(new WinningNumber(winningNumber))).isEqualTo(countWinnings);
    }
}
