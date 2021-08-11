package lotto.service;

import lotto.common.LottoResult;
import lotto.common.LottoResults;
import lotto.domain.LottoTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.RankingCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingServiceTest {

    @Test
    public void RankingService에서_몇개를_몇번맞췄는지_확인할_수_있다(){
        //given
        RankingService service = new RankingService();
        //when
        LottoResults lottoResults = service.calculateMatchHits(
                new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                        new LottoNumber(6))), initializeLottos(), new RankingCalculator());
        //then
        assertThat(lottoResults).isEqualTo(getExpected());
    }

    private LottoResults getExpected() {
        LottoResults expected = new LottoResults();
        expected.addAll(new LottoResult(3, 3), new LottoResult(4, 0), new LottoResult(5, 1), new LottoResult(6, 0));
        return expected;
    }

    private LottoTickets initializeLottos() {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(8), new LottoNumber(11),
                new LottoNumber(29))));
        lottoTickets.add(new LottoTicket(Arrays.asList(new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(6), new LottoNumber(9), new LottoNumber(10),
                new LottoNumber(22))));
        lottoTickets.add(new LottoTicket(Arrays.asList(new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(5), new LottoNumber(9), new LottoNumber(17),
                new LottoNumber(22))));
        lottoTickets.add(new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(8))));
        lottoTickets.add(new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(9), new LottoNumber(10), new LottoNumber(23),
                new LottoNumber(44))));
        return lottoTickets;
    }
}
