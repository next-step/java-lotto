package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.domain.Prize;
import org.junit.Test;

public class LottoTest {
    @Test
    public void 구입_금액에_따라_로또_발급개수가_결정되는지() {
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);

        assertThat(lottoTicket.getLottos().size()).isEqualTo(14);
    }

    @Test
    public void 로또의_각_번호는_1과_45사이인지() {
        Lotto lotto = new Lotto();

        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        lottoNumbers.forEach(lottoNumber -> assertThat(lottoNumber).isBetween(1, 45));
    }

    @Test
    public void 로또의_각_번호는_유일한지() {
        Lotto lotto = new Lotto();

        Set<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    public void 발급개수만큼_생성된_각_로또번호가_유일한지() {
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);
        List<Lotto> lottos = lottoTicket.getLottos();

        for (Lotto lotto : lottos) {
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
            assertThat(lottoNumbers.size()).isEqualTo(6);
        }
    }

    @Test
    public void 발급개수만큼_생성된_각_로또번호가_1과_45사이인지() {
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);
        List<Lotto> lottos = lottoTicket.getLottos();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            lottoNumbers.forEach(lottoNumber -> assertThat(lottoNumber).isBetween(1, 45));
        }
    }

    @Test
    public void 당첨결과에_보상순위와_매칭되는_당첨번호보유개수별_결과가_있는지() {
        final List<Integer> winnerNumbers = Arrays.asList(11, 12, 10, 1, 5, 16);
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);

        Map<Integer, List<Lotto>> lottoResults = lottoTicket.getWinningResult(winnerNumbers);

        assertThat(lottoResults.keySet())
            .isEqualTo(new HashSet<>(Arrays.asList(
                Prize.FIRST.getMatchingCount(),
                Prize.SECOND.getMatchingCount(),
                Prize.THIRD.getMatchingCount(),
                Prize.FOURTH.getMatchingCount())));
    }

    @Test
    public void 당첨번호_3개에_대한_결과가_맞는지() {
        final List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final int won = 14000;

        LottoTicket lottoTicket = LottoTicketMachine.purchase(won);

        Map<Integer, List<Lotto>> lottoResults = lottoTicket.getWinningResult(winnerNumbers);

        List<Lotto> lottos = lottoTicket.getLottos();

        int hasThreeNumber = 0;
        for (Lotto lotto : lottos) {
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());
            lottoNumbers.retainAll(winnerNumbers);

            if (lottoNumbers.size() == 3) {
                hasThreeNumber++;
            }
        }

        assertThat(lottoResults.get(3).size()).isEqualTo(hasThreeNumber);
    }
}
