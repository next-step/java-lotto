package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @DisplayName("당첨번호에 1~45 에 포함되지 않는 값을 넣으면 exception 이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,50", "1,2,3,4,5,-1"})
    void invalidNumber(String expression){
        assertThatThrownBy(() -> new WinningNumbers(expression, 45))
                .isInstanceOf(InvalidWinningNumberException.class);
    }

    @DisplayName("당첨번호에 null 이나 빈값을 넣으면 exception 이 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void invalidNumber2(String expression){
        assertThatThrownBy(() -> new WinningNumbers(expression, 45))
                .isInstanceOf(InvalidWinningNumberException.class);
    }

    @DisplayName("당첨번호에 숫자아 아닌 문자를 넣으면 exception 이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,a,4,5,6", "@,3,4,5,2,6"})
    void invalidNumber3(String expression){
        assertThatThrownBy(() -> new WinningNumbers(expression, 45))
                .isInstanceOf(InvalidWinningNumberException.class);
    }

    @DisplayName("당첨번호중 하나를 보너스 번호로 입력하면 exception 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void invalidBonusNumber(int bonusNumber){
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", bonusNumber ))
                .isInstanceOf(InvalidBonusNumberException.class);
    }

    @DisplayName("1~45 이외의 숫자를 보너스 번호로 입력하면 exception 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1,46})
    void invalidBonusNumber2(int bonusNumber){
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", bonusNumber ))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @DisplayName("구입한 로또에 보너스번호와 일치하는 번호가 있는지 확인 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,7:true", "1,2,3,4,5,6:false"})
    void matchBonus(String lottoNumber, boolean expected){
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 7);
        Lotto lotto = LottoUtils.lotto(lottoNumber);

        assertThat(winningNumbers.matchBonusNumber(lotto)).isEqualTo(expected);
    }

}