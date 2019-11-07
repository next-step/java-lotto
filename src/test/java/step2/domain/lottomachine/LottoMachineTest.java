package step2.domain.lottomachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.LottoNumber;
import step2.domain.LottoTicket;
import step2.exception.IllegalLottoNumberException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.helper.LottoHelper.makeLottoNumbersHelper;

class LottoMachineTest {

    @Test
    void 로또티켓_발급하기() {
        LottoMachine lottoMachine = new ManualLottoMachine();
        LottoTicket lottoTicket = lottoMachine.issueLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<LottoNumber> maybeNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        LottoTicket maybeTicket = new LottoTicket(maybeNumbers);

        assertThat(lottoTicket).isEqualTo(maybeTicket);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 99})
    void 올바르지않은_로또번호(Integer outOfRange) {
        LottoMachine lottoMachine = new ManualLottoMachine();
        assertThatThrownBy(() -> lottoMachine.issueLottoTicket(Arrays.asList(1, 2, 3, 4, 5, outOfRange)))
                .isInstanceOf(IllegalLottoNumberException.class)
                .hasMessage(outOfRange + "는 로또 번호가 아닙니다.");
    }
}