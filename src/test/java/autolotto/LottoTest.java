package autolotto;

import autolotto.model.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    @Test
    @DisplayName("생성된 로또 번호가 1 이상이면서 45 이하인가")
    public void isValidLottoNumbers(){
        Lotto lotto = new Lotto();
        for (int i = 0; i < 6; i++) {
            assertTrue(1 <= lotto.getNumber(i) && lotto.getNumber(i) <= 45);
        }
    }
}
