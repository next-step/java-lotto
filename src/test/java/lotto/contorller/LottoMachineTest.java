package lotto.contorller;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.controller.LottoMachine;
import lotto.domain.LottoCount;
import lotto.domain.LottoTicket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000})
    void 입력한_금액_만큼의_로또_갯수를_가진_티켓을_반환한다(int count) {
        //given
        LottoCount lottoCount = new LottoCount(count);
        //when
        LottoTicket lottoTicket = LottoMachine.purchaseLotto(lottoCount);
        //then
        assertThat(lottoTicket.lottoCount()).isEqualTo(count / 1000);
    }
}
