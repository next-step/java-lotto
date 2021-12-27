package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallTest {

    @Test
    void 공_생성_번호_정상() {
        assertThat(new Ball(1)).isEqualTo(new Ball(1));
        assertThat(new Ball(22)).isEqualTo(new Ball(22));
        assertThat(new Ball(45)).isEqualTo(new Ball(45));
    }

    @ParameterizedTest
    @ValueSource(strings={"-1", "0", "46"})
    void 공_생성_비정상_번호(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ball(input);
        }).withMessageMatching(Ball.VALID_BALL_NUMBER_MSG);
    }

}