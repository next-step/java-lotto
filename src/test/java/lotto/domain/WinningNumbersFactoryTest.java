package lotto.domain;

import lotto.factory.WinningNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersFactoryTest {

    @DisplayName("입력한 문자열이 list로 생성됨을 확인")
    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6")
    void winningNumbers(String numbers) {
        List<Integer> winningNumbers = WinningNumbersFactory.get(numbers);
        assertThat(winningNumbers).hasSize(6);
    }

    @DisplayName("입력한 문자열이 6개가 되지 않을 경우")
    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5")
    void winningNumbers_notEnoughNumbers(String numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbersFactory.get(numbers))
                .withMessageContaining("당첨 번호는 6개 숫자로 이루어져 있습니다.");
    }
}
