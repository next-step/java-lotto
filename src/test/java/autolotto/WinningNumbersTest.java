package autolotto;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨번호 6자리가 아니면 예외처리가 되는가")
    public void isNotSixNumber(){
        assertThrows(isNotSixNumberException.class, () -> {
            new WinningNumbers("1, 2, 3, 4, 5, 6, 7");
        });
    }

    @Test
    @DisplayName("숫자가 아니면 예외처리가 되는가")
    public void isNotNumber(){
        assertThrows(isNotNumberException.class, () -> {
           new WinningNumbers("1, 2, ㄱ, ㄴ, ㄷ, ㄹ, ㅁ");
        });
    }
}
