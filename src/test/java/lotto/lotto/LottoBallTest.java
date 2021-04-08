package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.lotto.LottoBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBallTest {
    @Test
    @DisplayName("로또 볼에는 1~45까지 숫자만 들어갈 수 있다.")
    void lottoBallLegitTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoBall(0))
                .withMessage("로또 번호는 1~45 사이 숫자로 입력해주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoBall(-1))
                .withMessage("로또 번호는 1~45 사이 숫자로 입력해주세요.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoBall(46))
                .withMessage("로또 번호는 1~45 사이 숫자로 입력해주세요.");
    }
}
