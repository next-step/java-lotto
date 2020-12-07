package autolotto;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class LottosComparerTest {

    @Test
    @DisplayName("로또번호가 모두 일치됬을 때 제대로 체크하는가")
    public void compareLottos(){
        Lotto lotto = new Lotto();
        StringBuilder lottoNumbers = lotto.getNumber(0);

        for (int i = 1; i < 6; i++) {
            lottoNumbers.append(", " + lotto.getNumber(i));
        }

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);

        LottosComparer lottosComparer = new LottosComparer(lotto, winningNumbers);
        assertEquals(lottosComparer.getMatchingCount(6) == 1);

    }
}
