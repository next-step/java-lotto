package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryRowInputViewTest {
    @Test
    public void testReadCommaSplicedInput() {
        var input = "1, 2, 3, 4, 5, 6";

        var inputView = new LotteryRowInputView(input);

        assertThat(inputView.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
