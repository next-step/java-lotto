package lottery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryCalculatorConsoleViewTest {
    @Test
    public void commaSplicedNumbersToIntegerListTest() {
        var commaSplicedNumbers = "1, 2, 3, 4, 5, 6";

        var lotteryCalculatorConsoleView = new LotteryCalculatorConsoleView();
        var result = lotteryCalculatorConsoleView.commaSplicedNumbersToIntegerList(commaSplicedNumbers);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
