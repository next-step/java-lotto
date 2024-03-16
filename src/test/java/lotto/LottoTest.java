package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("로또를 생성할때 숫자 6개가 나온다.")
    @Test
    public void getLottoNumbers() {
        //given
        Lotto lotto = new Lotto();

        //when & then
        assertThat(lotto.getNumberSize()).isEqualTo(6);
    }
}
