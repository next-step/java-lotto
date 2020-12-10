package autolotto;

import autolotto.exception.IsNotScopeInTheNumber;
import autolotto.exception.IsNotSixNumberException;
import autolotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨번호 6자리가 아니면 예외처리가 되는가")
    public void isNotSixNumber(){
        assertThrows(IsNotSixNumberException.class, () -> {
            new WinningNumbers("1, 2, 3, 4, 5, 6, 7");
        });
    }

    @Test
    @DisplayName("숫자가 아니면 예외처리가 되는가")
    public void isNotNumber(){
        assertThrows(NumberFormatException.class, () -> {
           new WinningNumbers("1, 2, ㄱ, ㄴ, ㄷ, ㄹ");
        });
    }

    @Test
    @DisplayName("당첨번호가 1에서 45까지의 숫자가 아니면 예외처리 되는가")
    public void isNotScopeInTheNumber(){
        assertThrows(IsNotScopeInTheNumber.class, () -> {
            new WinningNumbers("1, 2, 99, 5, 3, 4");
        });
    }
}
