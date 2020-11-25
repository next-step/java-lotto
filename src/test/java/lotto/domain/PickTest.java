package lotto.domain;

import lotto.domain.enums.PickType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PickTest {

    @Test
    void testGetBalls() {
        Pick pick = new Pick(PickType.AUTO, new LottoBalls(40, 30, 20, 10, 1, 45));
        assertThat(pick.getBalls()).isEqualTo(new LottoBalls(1, 10, 20, 30, 40, 45));
    }

    @Test
    void getPickType() {
        Pick pick = new Pick(PickType.AUTO, new LottoBalls(40, 30, 20, 10, 1, 33));
        assertThat(pick.getType()).isEqualTo(PickType.AUTO);
    }

    @Test
    void testGetBallString() {
        Pick pick = new Pick(PickType.AUTO, new LottoBalls(40, 30, 20, 10, 1, 33));
        assertThat(pick.getBalls().toString()).isEqualTo("1, 10, 20, 30, 33, 40");
    }
}
