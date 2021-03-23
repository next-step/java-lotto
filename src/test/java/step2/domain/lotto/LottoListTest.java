package step2.domain.lotto;

import org.junit.jupiter.api.Test;
import step2.domain.Money;

class LottoListTest {
    @Test
    void test() {
        LottoMachine lottoMachine = new LottoMachine();
        Money money = new Money(3000);
        LottoList lottoList = lottoMachine.buyAutoLotto(money);
        System.out.println(lottoList.dto());
    }
}
