package secondplacelotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("구매 가능한 로또를 제대로 가져오는")
    public void (){
        Money money = new Money(10000);

        assertEquals(money.ComputeBuyableLotto(), 10);
    }
}
