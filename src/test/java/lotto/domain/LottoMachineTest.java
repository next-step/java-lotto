package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoMachine.INVALID_LOTTO_PRICE_MESSAGE;
import static lotto.domain.LottoOptions.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {

    @DisplayName("로또는 한장당 1000원이며 구매금액 전부를 로또로 만든다.")
    @Test
    void purchase_lotto_as_money() {
        //given
        final Money money = new Money(10000);
        final LottoMachine lottoMachine = new LottoMachine(new Money(LOTTO_PRICE));
        final int purchableLottoCount = lottoMachine.getPurchableLottoCount(money);
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberAutoGenerator();
        final PurchaseInformation autoPurchaseInformation = new AutoPurchaseInformation(purchableLottoCount, 0);
        final int expected = 10;

        //when
        final List<Lotto> lottos = lottoMachine.pullSlot(autoPurchaseInformation, lottoNumberGenerator);

        //then
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @DisplayName("로또는 수동과 자동을 구분하여 생성한다.")
    @Test
    void lotto_is_created_separately_between_manual_and_automatic() {
        //given
        final LottoMachine lottoMachine = new LottoMachine(new Money(LOTTO_PRICE));
        final int allLottoCount = 10;
        final int manualCount = 2;
        final int expectedAutoCount = allLottoCount - manualCount;

        //when
        final List<Lotto> manualLottos = lottoMachine.pullSlot(
                new ManualPurchaseInformation(allLottoCount, manualCount),
                new LottoNumberManualGenerator(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,7")));
        final List<Lotto> autoLottos = lottoMachine.pullSlot(
                new AutoPurchaseInformation(allLottoCount, manualCount),
                new LottoNumberAutoGenerator());

        //then
        assertThat(manualLottos.size()).isEqualTo(manualCount);
        assertThat(autoLottos.size()).isEqualTo(expectedAutoCount);
    }

    @DisplayName("로또생성할 때 구매금액이 1000원 미만일시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 900, 999})
    void invalid_money_exception(final int money) {
        //given
        final LottoMachine lottoMachine = new LottoMachine(new Money(LOTTO_PRICE));

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> lottoMachine.getPurchableLottoCount(new Money(money)))
                .withMessageMatching(INVALID_LOTTO_PRICE_MESSAGE);
    }

}
