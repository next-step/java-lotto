package lotto.domain.lotto;

import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoOfficeTest {

    @DisplayName("Money가 null이면 LottoOffice를 만들수 없다")
    @Test
    public void throw_exception_money_is_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoOffice.of(null));
    }

    @DisplayName("금액에 맞는 로또를 반환한다")
    @Test
    public void should_return_count_of_lotto_in_money() throws Exception {
        //arrange
        Money money = Money.of(14000);
        LottoOffice lottoOffice = LottoOffice.of(money);

        //act
        LottoPackage lottoPackage = lottoOffice.purchase();

        //assert
        assertThat(lottoPackage.getAllLottoCount()).isEqualTo(14);
    }

}