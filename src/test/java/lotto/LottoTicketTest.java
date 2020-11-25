package lotto;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.SortedSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 매칭_로또_체크(){
        SortedSet<LottoNumber> inputNumbers = TestUtils.arrayToSortedSet(new int[]{1,2,3,4,5,6});
        SortedSet<LottoNumber> winnerNumbers = TestUtils.arrayToSortedSet(new int[]{1,2,3,43,44,45});

        LottoTicket lottoTicket = new LottoTicket(inputNumbers);
        LottoTicket winnerTicket = new LottoTicket(winnerNumbers);

        assertThat(winnerTicket.intersect(lottoTicket).getNumbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3)
        );

        assertThat(lottoTicket.intersect(winnerTicket).getNumbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3)
        );
    }
}
