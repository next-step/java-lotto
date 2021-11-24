package lotto;
import lotto.domain.*;
import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BonusBallTest {
    @Test
    @DisplayName("보너스볼이 당첨번호와 중복 테스트")
    void bonusBallTest() {
        WinningNumbers winningNumber = new WinningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(()->{
            BonusBall bonus = new BonusBall(winningNumber,new Number(1));
        }).hasMessageContaining("당첨 번호중에 이미 존재합니다").isInstanceOf(IllegalArgumentException.class);
    }
}
