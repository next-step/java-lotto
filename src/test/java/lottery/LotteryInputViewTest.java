package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryInputViewTest {
    @Test
    public void testInputToLotteryRow() {
        var input = "1, 2, 3, 4, 5, 6";

        var inputView = new LotteryInputView();
        var row = inputView.toLotteryRow(input);

        assertThat(row.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testInputToLotteryNumber() {
        var input = "10";

        var inputView = new LotteryInputView();
        var number =  inputView.toLotteryNumber(input);

        assertThat(number).isEqualTo(LotteryNumber.fromGiven(10));
    }

    @Test
    public void testInputToAmount() {
        var input = "10";

        var inputView = new LotteryInputView();
        var amount =  inputView.toNatural(input);

        assertThat(amount.value()).isEqualTo(10);
    }

    @Test
    public void testNonDigitInput() {
        assertThatThrownBy(() -> {
            var input = "a";

            var inputView = new LotteryInputView();
            inputView.toNatural(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input is not a non-negative integer");
    }

    @Test
    public void testEmptyLotteryRowInput() {
        assertThatThrownBy(() -> {
            var input = "";

            var inputView = new LotteryInputView();
            inputView.toLotteryNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input is empty");
    }

    @Test
    public void testEmptyNaturalNumberInput() {
        assertThatThrownBy(() -> {
            var input = "";

            var inputView = new LotteryInputView();
            inputView.toNatural(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input is empty");
    }
}
