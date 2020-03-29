package lotto.model.mylottos;

import lotto.model.mylottos.LottoNumbers;
import lotto.model.winninglotto.WinningLotto;
import lotto.model.winninglotto.WinningLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    @DisplayName("6개의 숫자로 구성되지 않은 숫자 리스트를 입력받으면 예외를 반환한다.")
    @Test
    void validateSizeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5));
        });
    }

    @DisplayName("중복된 숫자가 포함된 숫자 리스트를 입력받으면, 예외를 반환한다.")
    @Test
    void validateDuplicationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 1, 2, 3, 4, 5));
        });
    }

    @DisplayName("로또는 1 이상, 45 이하의 숫자로만 구성되어야 한다. 그렇지 않을 경우, 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateNumberRangeTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(input, 1, 2, 3, 4, 5));
        });
    }

    @DisplayName("구매한 로또 번호와 당첨 로또 번호를 인자로 주면, 두 번호 간 일치한 숫자의 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:5", "7:6", "8:5", "9:5"}, delimiter = ':')
    void findHowManyMatchTest(int input, int expected) {
        //given
        WinningLottoNumbers winningLottoNumbers= new WinningLottoNumbers(Arrays.asList(input, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7));

        //when
        int howManyMatch = lottoNumbers.findHowManyMatch(WinningLotto.of(winningLottoNumbers));

        //then
        assertThat(howManyMatch).isEqualTo(expected);
    }
}