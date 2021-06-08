package kr.aterilio.nextstep.techcamp.m1.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {

    @DisplayName("보너스 볼이 1-45 범위에 속하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void createBonusBallFailed_outOfRange(int bonusBall) {
        assertThatThrownBy(() -> {
            new BonusBall(bonusBall);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @DisplayName("당첨 번호와 보너스 볼에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6+1", "1,2,3,4,5,1+4"}, delimiter = '+')
    public void createBonusBallFailed_duplicated(String inputLuckyNumbers, int bonusBall) {
        assertThatThrownBy(() -> {
            new LuckyNumbers(inputLuckyNumbers, bonusBall);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }
}
