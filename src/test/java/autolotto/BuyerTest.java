package autolotto;

import autolotto.model.Buyer;
import autolotto.model.Lottos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BuyerTest {

    @Test
    @DisplayName("돈을 가진 구매자가 잘 만들어 지는가")
    public void createBuyer(){
        Buyer buyer = new Buyer(10000);

        buyer.buyLottos();

        Lottos lottos = buyer.getLottos();

        assertEquals(lottos.getLottosCount(),10);
    }
}
