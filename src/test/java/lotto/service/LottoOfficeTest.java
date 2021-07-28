package lotto.service;

import lotto.domain.lotto.LottoBunch;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoOfficeTest {

    @DisplayName("금액에 맞는 로또를 반환한다")
    @Test
    public void should_return_count_of_lotto_in_money() throws Exception {
        //arrange
        Money money = Money.of(14000);
        LottoOffice lottoOffice = new LottoOffice(money);

        //act
        LottoBunch lottoBunch = lottoOffice.purchase();

        //assert
        assertThat(lottoBunch.getAllLottoCount()).isEqualTo(14);
    }

}