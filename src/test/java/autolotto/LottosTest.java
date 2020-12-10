package autolotto;

import autolotto.exception.NotEnoughMoneyException;
import autolotto.model.Lottos;
import autolotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottosTest {

    @Test
    @DisplayName("금액에 맞는 갯수만큼 로또가 생성되었는가")
    public void createLottos(){
        Money money = new Money(14000);
        Money money2 = new Money(13500);
        Lottos lottos = new Lottos(money);
        Lottos lottos2 = new Lottos(money2);

        assertEquals(lottos.getLottosCount(),14);
        assertEquals(lottos2.getLottosCount(),13);
    }

    @Test
    @DisplayName("1개 금액보다 적게 입력 시 예외처리를 하는가")
    public void beShortOfMoney(){
        assertThrows(NotEnoughMoneyException.class, () -> {
            Money money = new Money(500);
            Lottos lottos = new Lottos(money);
        });
    }
}
