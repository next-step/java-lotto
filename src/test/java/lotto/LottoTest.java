package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("로또 구매 갯수를 구한다.")
    @Test
    public void getBuyLottoNumber() {
        //given
        int amount = 14000;
        Seller seller = new Seller();

        //when
        int buyLottoNumber = seller.getBuyLottoNumber(amount);

        //then
        assertThat(buyLottoNumber).isEqualTo(14);
    }
}
