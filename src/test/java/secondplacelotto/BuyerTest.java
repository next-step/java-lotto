package secondplacelotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import secondplacelotto.model.Buyer;
import secondplacelotto.model.Money;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyerTest {

    @Test
    @DisplayName("구매자가 가진 돈만큼의 로또를 구매하는가")
    public void buyLottos() {
        Buyer buyer = new Buyer(new Money(10300));
        assertTrue(buyer.buyLottos().getLottosCount() == 10);
    }
}
