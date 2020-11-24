package lotto.domain;

import lotto.domain.enums.PickType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PickTest {

    @Test
    void testGetBalls() {
        Pick pick = new Pick(PickType.AUTO, Arrays.asList(40, 30, 20, 10, 1));
        assertThat(pick.getBalls()).containsExactly(1, 10, 20, 30, 40);
    }

    @Test
    void getPickType(){
        Pick pick = new Pick(PickType.AUTO, Arrays.asList(40, 30, 20, 10, 1));
        assertThat(pick.getType()).isEqualTo(PickType.AUTO);
    }

    @Test
    void testGetBallString(){
        Pick pick = new Pick(PickType.AUTO, Arrays.asList(40, 30, 20, 10, 1));
        assertThat(pick.getBallsString()).isEqualTo("1, 10, 20, 30, 40");
    }
}
