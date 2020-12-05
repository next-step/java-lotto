package autolotto;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Scanner;

public class LottosTest {

    @Test
    @DisplayName("금액에 맞는 갯수만큼 로또가 생성되었는가")
    public void createLottos(){
        Lottos lottos = new Lottos(14000);
        Lottos lottos2 = new Lottos(13500);

        assertEquals(lottos.getLottoCount(),14);
        assertEquals(lottos2.getLottoCount(),13);
    }

    @Test
    @DisplayName("1개 금액보다 적게 입력 시 예외처리를 하는가")
    public void beShortOfMoney(){
        assertThrows(BeShortOfMoneyException.class, () -> {
            Lottos lottos = new Lottos(500);
        });
    }
}
