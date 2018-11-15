package lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AmountTest {

    @Test
    public void 금액_4000원() {
        Amount amount = new Amount(4000);

        assertThat(amount.getValue()).isEqualTo(4000);
    }

    @Test
    public void purcharseTicket_2장() {
        Amount amount = new Amount(4000);
        amount.purcharseTicket(2);

        assertThat(amount.getValue()).isEqualTo(2000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void purcharseTicket_100장() {
        Amount amount = new Amount(4000);
        amount.purcharseTicket(100);
    }


    @Test
    public void getProfitRate_2배() {
        Amount amount = new Amount(4_000);
        double profitRate = amount.getProfitRate(8000);
        assertThat(profitRate).isEqualTo(2.0);
    }
}