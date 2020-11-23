package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스번호가 1~45 사이 숫자가 아니면 exception 이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void invalidNumber(int bonusNumber){
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(InvalidBonusNumberException.class);
    }

    @DisplayName("보너스번호와 일치하는지 여부를 matcher 로 확인 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "5:true"}, delimiterString = ":")
    void match(int number, boolean expected){
        BonusNumber bonusNumber = new BonusNumber(5);

        assertThat(bonusNumber.getNumberMatcher().match(number)).isEqualTo(expected);
    }

}