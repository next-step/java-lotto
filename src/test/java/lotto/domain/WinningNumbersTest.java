package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    private int bonusNumber = 45;

    @DisplayName("로또 당첨 번호와 일치한 갯수를 확인한다")
    @Test
    void matchWinningNumber(){
        WinningNumbers winningNumbers = new WinningNumbers(bonusNumber, 1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(1, 2, 3, 43, 44, 45);

        int matchNumberCount = winningNumbers.matchWinningNumber(lotto);

        assertThat(matchNumberCount).isEqualTo(3);
    }

    @DisplayName("당첨번호는 6개의 숫자만 입력되어야 한다")
    @Test
    void limitCount(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(bonusNumber, 1, 2, 3))
                .withMessage("당첨 번호를 6개 입력하세요");
    }

    @DisplayName("당첨번호는 중복된 번호가 없어야 한다")
    @Test
    void checkDuplicateNumber(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(bonusNumber, 1, 1, 1, 3, 4, 5))
                .withMessage("당첨 번호가 중복됐습니다");
    }


    @DisplayName("당첨번호와 보너스 번호는 중복되면 안된다")
    @Test
    void checkDuplicateNumberAndBonusNUmber(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(bonusNumber, 45, 1, 3, 4, 5, 6))
                .withMessage("당첨 번호와 보너스 번호가 중복됐습니다");
    }
}
