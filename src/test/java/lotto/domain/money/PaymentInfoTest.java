package lotto.domain.money;

import lotto.domain.lotto.ManualLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.lotto.LottoOffice.LOTTO_PRICE_OF_SINGLE;
import static lotto.fixture.LottoFixture.getFiveManaualLottos;
import static lotto.fixture.LottoFixture.getOneManaualLottos;
import static org.assertj.core.api.Assertions.*;

@DisplayName("구매 정보를 담고 있는 클래스 테스트")
class PaymentInfoTest {

    @DisplayName("PaymentInfo는 구매 금액과 수동 로또 티켓을 가지고 생성한다")
    @Test
    void should_create_paymentInfo() {
        //arrange
        Money money = Money.of(1_000);
        ManualLottos lottos = getOneManaualLottos();

        //act
        PaymentInfo paymentInfo = PaymentInfo.of(money, lottos);

        //assert
        assertThat(paymentInfo).isNotNull();
    }

    @DisplayName("Money가 null이면 IllegalStateException을 반환한다")
    @Test
    void throw_exception_money_null() {
        //arrange, act, assert
        assertThatIllegalStateException().isThrownBy(()
                -> PaymentInfo.of(null, getOneManaualLottos()));
    }

    @DisplayName("수동 로또의 구매가 주어진 금액이상일경우 IllegalStateException을 반환한다")
    @Test
    void throw_exception_manauallottos_over_than_money() {
        //arrange
        Money money = Money.of(1_000);
        ManualLottos lottos = getFiveManaualLottos();

        //act, assert
        assertThatIllegalStateException().isThrownBy(() -> PaymentInfo.of(money, lottos));
    }

    @DisplayName("수동 로또와 자동 로또를 합쳐서 Money 이내에서 구매가능하다")
    @Test
    void can_purcahse_lotos_auto_with_manaual() {
        //arrange
        Money money = Money.of(7_000);
        ManualLottos lottos = getFiveManaualLottos();
        PaymentInfo paymentInfo = PaymentInfo.of(money, lottos);
        int expectRemainCount = 2;

        //act
        int remainCount = paymentInfo.getAffordableCount(LOTTO_PRICE_OF_SINGLE);

        //assert
        assertThat(remainCount).isEqualTo(expectRemainCount);
    }

}
