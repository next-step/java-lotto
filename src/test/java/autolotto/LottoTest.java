package autolotto;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class LottoTest {

    @Test
    @DisplayName("생성된 로또 번호가 1 이상이면서 45 이하인가")
    public void isValidLottoNumbers(){
        Lotto lotto = new Lotto();
        for (int i = 0; i < 6; i++) {
            assertTrue(1 <= lotto.get(i) && lotto.get(i) <= 45);
        }
    }
}
