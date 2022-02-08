package lotto.contorller;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.controller.LottoMachine;
import lotto.domain.LottoCount;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000})
    void 입력한_금액_만큼의_로또_갯수를_가진_티켓을_반환한다(int money) {
        //given
        Money money1 = new Money(String.valueOf(money));
        LottoCount lottoCount = LottoCount.from(money1);
        //when
        LottoTicket lottoTicket = LottoMachine.purchaseLotto(lottoCount);
        //then
        assertThat(lottoTicket.lottoCount()).isEqualTo(money / 1000);
    }
}
