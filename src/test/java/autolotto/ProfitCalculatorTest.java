package autolotto;

import autolotto.model.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산을 제대로 하는가")
    public void calculateProfit(){
        Lottos lottos = new Lottos(1000);
        StringBuilder lottoNumbers = new StringBuilder();
        Lotto lotto = lottos.getLotto(0);

        lottoNumbers.append(lotto.getNumbers(0));

        for (int i = 1; i < 6; i++) {
            lottoNumbers.append(", " + lotto.getNumbers(i));
        }

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers.toString());

        LottosComparer lottosComparer = new LottosComparer(lottos, winningNumbers.getNumbers());
        System.out.println(lottosComparer.getMatchingCount(6));
        assertEquals(200000.0, ProfitCalculator.calculate(10000, lottosComparer), 0.0);
    }
}
