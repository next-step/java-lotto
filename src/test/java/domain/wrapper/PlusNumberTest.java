package domain.wrapper;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlusNumberTest {

    @Test(expected = RuntimeException.class)
    public void 음수예외테스트() {
        new BuyLotto(-1);
    }

    @Test(expected = RuntimeException.class)
    public void 로또범위예외테스트() {
        new LottoNo(1000);
    }

    @Test
    public void 같은형태테스트() {
        Money lottoCombineCount = new Money(1000);
        Money money = new Money(1000);
        assertThat(money.equalsNumber(lottoCombineCount)).isTrue();
    }
    @Test(expected = RuntimeException.class)
    public void 계산후_음수테스트() {
        Money money = new Money(1000);
        BuyLotto buyLotto = new BuyLotto(3);
        money.subtract(buyLotto);
    }

    @Test
    public void 같은형태테스트1() {
        Money money = new Money(5000);
        BuyLotto buyLotto = new BuyLotto(3);
        Money money2 = new Money(2000);
        money.subtract(buyLotto);
        assertThat(money.equalsNumber(money2)).isTrue();
    }

    @Test
    public void 로또개수테스트() {
        BuyLotto buyLotto = new BuyLotto(3);
        assertThat(buyLotto.getLottoCount()).isEqualTo(3);
    }


}