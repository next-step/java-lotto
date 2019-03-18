package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import org.junit.Test;

public class LottoTest {
    @Test
    public void 구입_금액에_따라_로또_발급개수가_결정되는지() {
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);

        assertThat(lottoTicket.getLottosCount()).isEqualTo(14);
    }

    @Test
    public void 로또의_각_숫자는_1과_45사이인지() {
        Lotto lotto = new Lotto();

        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        lottoNumbers.forEach(lottoNumber -> assertThat(lottoNumber).isBetween(1, 45));
    }

    @Test
    public void 로또의_각_숫자는_유일한지() {
        Lotto lotto = new Lotto();

        Set<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    public void 발급개수만큼_로또_생성되었는지() {
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);
        List<Lotto> lottos = lottoTicket.publish();

        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    public void 발급개수만큼_생성된_각_로또숫자가_유일한지() {
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);
        List<Lotto> lottos = lottoTicket.publish();

        for (Lotto lotto : lottos) {
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
            assertThat(lottoNumbers.size()).isEqualTo(6);
        }
    }

    @Test
    public void 발급개수만큼_생성된_각_로또숫자가_1과_45사이인지() {
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);
        List<Lotto> lottos = lottoTicket.publish();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            lottoNumbers.forEach(lottoNumber -> assertThat(lottoNumber).isBetween(1, 45));
        }
    }
}
