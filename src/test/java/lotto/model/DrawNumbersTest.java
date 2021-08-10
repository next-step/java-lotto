package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("추첨 번호 테스트")
public class DrawNumbersTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 Exception이 발생한다.")
    @Test
    public void duplicatedWinningNumbersAndBonusNumberExceptionTest() {
        // given
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.valueOf(6);

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new DrawNumbers(winningNumbers, bonusNumber))
                .withMessage("당첨 번호와 보너스 번호가 중복 되었습니다.");
    }
}
