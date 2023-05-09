package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LotteryNumberTest {
    @Test
    public void throwsExceptionOnOutOfRangeNumber() {
        assertThatThrownBy(() -> {
            LotteryNumber.fromGiven(98434);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
