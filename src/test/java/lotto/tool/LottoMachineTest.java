package lotto.tool;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void 수동발급장수_가능확인() {
        LottoMoney lottoMoney = new LottoMoney(3_000);
        boolean isPossible = LottoMachine.checkManualTicketCount(lottoMoney.buy(), 0);
        assertThat(isPossible).isEqualTo(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동장수_범위초과_에러확인() {
        LottoMoney lottoMoney = new LottoMoney(3_000);
        boolean isPossible = LottoMachine.checkManualTicketCount(lottoMoney.buy(), 10);
        assertThat(isPossible).isEqualTo(true);
    }

    @Test
    public void 수동_자동_혼합() {
        String[] manual1 = {"1","2","3","4","5","6"};
        String[] manual2 = {"11","12","13","14","15","16"};
        List<String[]> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manual1);
        manualLottoNumbers.add(manual2);
        LottoMoney lottoMoney = new LottoMoney(10000);

        LottoBundle lottoBundle = LottoMachine.issueTickets(lottoMoney, manualLottoNumbers);
        assertThat(lottoBundle.getTickets().size()).isEqualTo(10);
    }

    @Test
    public void 수동_0장_자동_혼합() {
        List<String[]> manualLottoNumbers = new ArrayList<>();
        LottoMoney lottoMoney = new LottoMoney(10000);
//        List<LottoTicket> lottoTickets = LottoMachine.issueTickets(lottoMoney, manualLottoNumbers);
        LottoBundle lottoBundle = LottoMachine.issueTickets(lottoMoney, manualLottoNumbers);

        for (LottoTicket lottoTicket : lottoBundle.getTickets()) {
            System.out.println(lottoTicket.toString());
        }
        assertThat(lottoBundle.getTickets().size()).isEqualTo(10);
    }


    @Test
    public void 수동티켓발급() {
        String[] manual1 = {"1","2","3","4","5","6"};
        String[] manual2 = {"11","12","13","14","15","16"};
        List<String[]> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manual1);
        manualLottoNumbers.add(manual2);

        LottoMoney lottoMoney = new LottoMoney(2_000);

        List<LottoTicket> lottoTickets = LottoMachine.generateManualTickets(new LottoManualGenerator(manualLottoNumbers, lottoMoney));
        assertThat(lottoTickets.size()).isEqualTo(2);
    }

    @Test
    public void 수동_자동_혼합2() {
        String[] manual1 = {"1","2","3","4","5","6"};
        String[] manual2 = {"11","12","13","14","15","16"};
        List<String[]> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(manual1);
        manualLottoNumbers.add(manual2);
        LottoMoney lottoMoney = new LottoMoney(10000);

//        LottoBundle lottoBundle = LottoMachine.issueLottoTickets(lottoMoney, manualLottoNumbers);
        LottoBundle lottoBundle = LottoMachine.issueLottoTickets(lottoMoney, manualLottoNumbers);
        assertThat(lottoBundle.getTickets().size()).isEqualTo(10);
    }
}
