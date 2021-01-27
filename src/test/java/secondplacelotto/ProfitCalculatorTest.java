package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.model.BonusNumber;
import secondplacelotto.model.MatchingNumbers;
import secondplacelotto.model.ProfitCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("매칭된 로또별로 수익률 계산을 제대로 하는가?")
    public void calculateProfit() {
        MatchingNumbers matchingNumbers = new MatchingNumbers();

        assertEquals(ProfitCalculator.calculate(matchingNumbers,10000), 0.0);

        matchingNumbers.addMatchingCount("3");
        assertEquals(ProfitCalculator.calculate(matchingNumbers,10000), 150.0);

        matchingNumbers.addMatchingCount("1");
        assertEquals(ProfitCalculator.calculate(matchingNumbers,10000), 200150.0);
    }

}
