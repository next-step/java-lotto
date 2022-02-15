package lotto.contorller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import lotto.controller.LottoMachine;
import lotto.domain.LottoCount;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2"})
    void 입력한_금액_만큼의_자동로또_갯수를_가진_티켓을_반환한다(String money, int count) {
        //given
        Money money1 = new Money(money);
        LottoCount lottoCount = LottoCount.from(money1);
        //when
        LottoTicket lottoTicket = LottoMachine.purchaseLotto(lottoCount, new ArrayList<>());
        //then
        assertThat(lottoTicket.lottoCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000|1,2,3,4,5,6", "1000|7,10,20,30,40,45"}, delimiter = '|')
    void 입력한_수동_로또를_가진_티켓을_반환한다(String money, String manualLotto) {
        //given
        Money money1 = new Money(money);
        LottoCount lottoCount = LottoCount.from(money1);
        //when
        LottoTicket lottoTicket = LottoMachine.purchaseLotto(lottoCount,
            Collections.singletonList(manualLotto));
        //then
        assertThat(lottoTicket.lottoCount()).isEqualTo(2);
    }
}
