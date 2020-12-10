package autolotto;

import autolotto.model.Lotto;
import autolotto.model.Lottos;
import autolotto.model.LottosComparer;
import autolotto.model.WinningNumbers;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class LottosComparerTest {

    @Test
    @DisplayName("로또번호가 일치됬을 때 제대로 체크하는가")
    public void compareLottos(){
        Lottos lottos = new Lottos(1000);
        StringBuilder lottoNumbers = new StringBuilder();
        Lotto lotto = lottos.getLotto(0);

        lottoNumbers.append(lotto.getNumber(0));

        for (int i = 1; i < 6; i++) {
            lottoNumbers.append(", ").append(lotto.getNumber(i));
        }
        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers.toString());

        LottosComparer lottosComparer = new LottosComparer(lottos, winningNumbers.getNumbers());

        assertEquals(lottosComparer.getMatchingCount(6),1);

    }
}
