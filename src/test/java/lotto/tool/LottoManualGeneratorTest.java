package lotto.tool;

import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoManualGeneratorTest {

    @Test
    public void 수동_티켓생성확인() {
        String[] manual1 = {"1","2","3","4","5","6"};
        String[] manual2 = {"11","12","13","14","15","16"};
        List<String[]> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manual1);
        manualLottoNumbers.add(manual2);

        LottoMoney lottoMoney = new LottoMoney(2_000);

        LottoGenerator lottoManualGenerator = new LottoManualGenerator(manualLottoNumbers, lottoMoney);
        List<LottoTicket> lottoTickets = lottoManualGenerator.generate();
        assertThat(lottoTickets.size()).isEqualTo(2);
    }
}