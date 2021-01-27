package autolotto;

import autolotto.model.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산을 제대로 하는가")
    public void calculateProfit(){
        Money money = new Money(1000);
        Lottos lottos = new Lottos(money);
        StringBuilder lottoNumbers = new StringBuilder();
        Lotto lotto = lottos.getLotto(0);

        lottoNumbers.append(lotto.getNumber(0));

        for (int i = 1; i < 6; i++) {
            lottoNumbers.append(", " + lotto.getNumber(i));
        }

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers.toString());
        MatchingNumbers matchingNumbers = new MatchingNumbers();
        lottos.matchLotto(winningNumbers.getNumbers(), matchingNumbers);
        assertEquals(200000.0, ProfitCalculator.calculate(10000, matchingNumbers), 0.0);
    }
}
