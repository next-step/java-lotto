package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberAutoGenerator();
        final int expected = 10;

        //when
        final List<Lotto> lottos = lottoMachine.pullSlot(money, lottoNumberGenerator);

        //then
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @DisplayName("로또생성할 때 구매금액이 1000원 미만일시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 900, 999})
    void invalid_money_exception(final int money) {
        //given
        final LottoMachine lottoMachine = new LottoMachine(new Money(LOTTO_PRICE));

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() ->
                lottoMachine.pullSlot(new Money(money), new LottoNumberAutoGenerator()))
                .withMessageMatching(INVALID_LOTTO_PRICE_MESSAGE);
    }

}
