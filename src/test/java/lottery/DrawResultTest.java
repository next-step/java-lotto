package lottery;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DrawResultTest {
    @Test
    public void throwErrorIfWinningRowContainsBonus() {
        assertThatThrownBy(() -> new DrawResult(LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 6)), LotteryNumber.fromGiven(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Winning row contains bonus");
    }
}
