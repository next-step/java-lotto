package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Ticket;
import lotto.utils.ManualLottoGenerator;
import lotto.utils.TestRandomLottoGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void 구입금액_음수입력시_예외() {
        int money = -1000;
        int manualCount = 3;
        List<Ticket> manualLottoNumbers = new ArrayList<>();
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);

        LottoStore lottoStore = new LottoStore(new ManualLottoGenerator(), new TestRandomLottoGenerator(), money, manualLottoNumbers);
    }

    @Test
    public void 수동_자동_총합_횟수만큼_로또_생성() {
        int money = 10000;
        int manualCount = 3;
        List<Ticket> manualLottoNumbers = new ArrayList<>();
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);

        LottoStore lottoStore = new LottoStore(new ManualLottoGenerator(), new TestRandomLottoGenerator(), money, manualLottoNumbers);

        assertThat(lottoStore.getLottos().size()).isEqualTo(10);
    }

    @Test
    public void 테스트전용_로또생성기로_로또생성() {
        int money = 10000;
        int manualCount = 3;
        List<Ticket> manualLottoNumbers = new ArrayList<>();
        Ticket ticket = new Ticket(1, 2, 3, 4, 5, 6);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);
        manualLottoNumbers.add(ticket);

        LottoStore lottoStore = new LottoStore(new ManualLottoGenerator(), new TestRandomLottoGenerator(), money, manualLottoNumbers);


        assertThat(lottoStore.getLottos().get(0).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
