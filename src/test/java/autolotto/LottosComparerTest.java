package autolotto;

import autolotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LottosComparerTest {

    @Test
    @DisplayName("로또번호가 일치됬을 때 제대로 체크하는가")
    public void compareLottos(){
        Money money = new Money(1000);
        Lottos lottos = new Lottos(money);
        StringBuilder lottoNumbers = new StringBuilder();
        Lotto lotto = lottos.getLotto(0);

        lottoNumbers.append(lotto.getNumber(0));

        for (int i = 1; i < 6; i++) {
            lottoNumbers.append(", ").append(lotto.getNumber(i));
        }
        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers.toString());
        MatchingNumbers matchingNumbers = new MatchingNumbers();
        lottos.matchLotto(winningNumbers.getNumbers(), matchingNumbers);

        assertEquals(matchingNumbers.getMatchingCount(6),1);

    }
}
