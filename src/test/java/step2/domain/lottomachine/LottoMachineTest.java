package step2.domain.lottomachine;

import org.junit.jupiter.api.Test;
import step2.domain.LottoNumber;
import step2.domain.LottoTicket;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.helper.LottoHelper.makeLottoNumbersHelper;

class LottoMachineTest {

    @Test
    void 로또티켓_발급하기() {
        LottoMachine lottoMachine = new FixedLottoMachine(0);
        LottoTicket lottoTicket = lottoMachine.issueLottoTicket();

        List<LottoNumber> maybeNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        LottoTicket maybeTicket = new LottoTicket(maybeNumbers);

        assertThat(lottoTicket).isEqualTo(maybeTicket);
    }
}