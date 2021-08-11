package lotto.domain;

import lotto.common.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingCalculatorTest {

    @Test
    public void 지난주_당첨번호와_구매한_로또목록이_존재할_때_일치하는_갯수의_카운트를_셀_수_있다() {
        //given
        RankingCalculator calculator = new RankingCalculator();
        List<LottoNumber> lastWeekWinning = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6)));
        LottoTickets lottoTickets = initializeLottos();
        //when
        LottoResult lottoResult= calculator.calculate(lastWeekWinning, lottoTickets, 3);
        //then
        assertThat(lottoResult).isEqualTo(new LottoResult(3, 3));
    }

    @Test
    public void 지난주_당첨번호와_구매한_로또목록이_존재할_때_일치하는_갯수가_없다면_결과는_0이다() {
        //given
        RankingCalculator calculator = new RankingCalculator();
        List<LottoNumber> lastWeekWinning = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6)));
        LottoTickets lottoTickets = initializeLottos();
        //when
        LottoResult lottoResult = calculator.calculate(lastWeekWinning, lottoTickets, 1);
        //then
        assertThat(lottoResult).isEqualTo(new LottoResult(1, 0));
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
