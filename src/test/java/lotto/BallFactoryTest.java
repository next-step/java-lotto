package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

public class BallFactoryTest {

    @RepeatedTest(100)
    void generate() {
        Ball ball = BallFactory.generate();
        assertThat(ball.number()).isBetween(1, 45);
    }
}
