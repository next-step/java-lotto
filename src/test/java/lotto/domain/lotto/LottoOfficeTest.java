package lotto.domain.lotto;

import lotto.domain.money.Money;
import lotto.domain.money.PaymentInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.fixture.LottoFixture.getOneManaualLottos;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoOfficeTest {

    @DisplayName("수동로또없이 자동로또로만 금액에 맞는 로또를 반환한다")
    @Test
    public void should_return_count_of_lotto_in_money_when_only_auto_lottos() throws Exception {
        //arrange
        Money money = Money.of(14000);
        Lottos manualLottos = null;
        PaymentInfo paymentInfo = PaymentInfo.of(money, null);

        //act
        Lottos lottos = LottoOffice.purchase(paymentInfo, manualLottos);

        //assert
        assertThat(lottos.size()).isEqualTo(14);
    }

    @DisplayName("수동로또와 자동로도 합쳐서 금액에 맞는 로또를 반환한다")
    @Test
    public void should_return_count_of_lotto_in_money_when_with_manual_lottos() throws Exception {
        //arrange
        Money money = Money.of(14000);
        ManualLottos lottos = getOneManaualLottos();
        PaymentInfo paymentInfo = PaymentInfo.of(money, lottos);

        //act
        Lottos resultLottos = LottoOffice.purchase(paymentInfo, lottos);

        //assert
        assertThat(resultLottos.size()).isEqualTo(14);
    }

}