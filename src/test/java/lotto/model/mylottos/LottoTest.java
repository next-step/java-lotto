package lotto.model.mylottos;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.Lotto;
import lotto.model.winninglotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @DisplayName("6개의 숫자로 구성되지 않은 숫자 리스트를 입력받으면 예외를 반환한다.")
    @Test
    void validateSizeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(
                    LottoNumber.of(1)));
        });
    }

    @DisplayName("중복된 숫자가 포함된 숫자 리스트를 입력받으면, 예외를 반환한다.")
    @Test
    void validateDuplicationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(
                    LottoNumber.of(1),
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5)
            ));
        });
    }

    @DisplayName("로또는 1 이상, 45 이하의 숫자로만 구성되어야 한다. 그렇지 않을 경우, 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateNumberRangeTest(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(
                    LottoNumber.of(input),
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5)));
        });
    }

    @DisplayName("구매한 로또 번호와 당첨 로또 번호를 인자로 주면, 두 번호 간 일치한 숫자의 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:6", "7:5"}, delimiter = ':')
    void findHowManyMatchTest(int input, int expected) {
        //given
        Lotto winningLotto = new Lotto(Arrays.asList(
                LottoNumber.of(input),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        ));
        Lotto lotto = new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        ));

        //when
        int howManyMatch = lotto.findHowManyMatch(WinningLotto.of(winningLotto));

        //then
        assertThat(howManyMatch).isEqualTo(expected);
    }
}