package camp.nextstep.edu.lottery;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LotteryGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("로또를 정상적으로 잘 생성한다")
    void successfullyCreate() {
        assertDoesNotThrow(() -> LotteryGenerator.create());
    }
}
