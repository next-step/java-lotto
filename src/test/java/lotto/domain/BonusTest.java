package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BonusTest {
    @Test
    void create() {
        assertThat(new Bonus(3)).isEqualTo(new Bonus(3));
    }

    @Test
    void 당첨번호_중복() {
        List<Integer> winNumbers = new Winning().createWinNumbers("1,2,3,4,5,6");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Bonus(6).checkDuplicateWithWinning(winNumbers))
                .withMessageMatching("당첨번호와 보너스 볼이 중복됩니다.");
    }
}
