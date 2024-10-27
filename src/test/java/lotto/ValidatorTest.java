package lotto;

import lotto.utility.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidatorTest {

    @Test
    @DisplayName("입력받은 숫자에 대해 1이상 45이하의 숫자인지 확인하는 테스트")
    public void isValidNumber() {
        assertThatThrownBy(() -> Validator.isValidNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 수는 1부터 45까지의 숫자만 가능합니다.");

        assertThatThrownBy(() -> Validator.isValidNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 수는 1부터 45까지의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("입력받은 숫자들에 대해 1이상 45이하의 숫자인지 확인하는 테스트")
    public void isValidNumbers1() {
        assertThatThrownBy(() -> Validator.isValidNumbers(List.of(1, 48, 3, 41, 15, 32)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 수는 1부터 45까지의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("입력받은 당첨번호의 개수가 6개인지 확인하는 테스트")
    public void isValidNumbers2() {
        assertThatThrownBy(() -> Validator.isValidNumbers(List.of(1, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자의 개수는 반드시 6개여야 합니다.");
    }

    @Test
    @DisplayName("입력받은 당첨번호에 중복되는 번호가 있는지 확인하는 테스트")
    public void isValidNumbers3() {
        assertThatThrownBy(() -> Validator.isValidNumbers(List.of(1, 3, 3, 41, 15, 32)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 당첨번호가 입력되었습니다.");
    }

    @Test
    @DisplayName("입력받은 당첨번호와 보너스 번호가 중복되는지 확인하는 테스트")
    public void isValidBonusNumber() {
        assertThatThrownBy(() -> Validator.isValidBonusNumber("1, 2, 3, 4, 5, 6", 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지난 주 당첨 번호와 보너스 볼이 중복 되었습니다.");
    }

}