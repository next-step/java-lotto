package step4;

import org.junit.jupiter.api.Test;
import step4.domain.LottoMachine;
import step4.domain.LottoTicketCount;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void buyLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicketCount lottoTicketCount = new LottoTicketCount(14000, 3);
        List<String> ManualLottoNumbers = Arrays.asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44");
        assertThat(lottoMachine.buyLotto(lottoTicketCount, ManualLottoNumbers).getLottoList()).hasSize(14);
    }
}
