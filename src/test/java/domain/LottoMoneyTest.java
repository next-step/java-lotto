package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LottoMoneyTest {

    @Test(expected = IllegalArgumentException.class)
    public void 구입금액이_1000원_미만이면_에러() {
        // when
        new LottoMoney(999);
    }

    @Test
    public void 로또_구입_개수_구하기() {
        // given
        int price = LottoMoney.TICKET_PRICE * 14;
        LottoMoney lottoMoney = new LottoMoney(price);

        //  when
        int tryNo = lottoMoney.calculateTryNo();

        // then
        assertThat(tryNo, is(14));
    }
}