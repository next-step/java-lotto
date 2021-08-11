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
        List<Integer> lastWeekWinning = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = initializeLottos();
        //when
        LottoResult lottoResult= calculator.calculate(lastWeekWinning, lottos, 3);
        //then
        assertThat(lottoResult).isEqualTo(new LottoResult(3, 3));
    }

    @Test
    public void 지난주_당첨번호와_구매한_로또목록이_존재할_때_일치하는_갯수가_없다면_결과는_0이다() {
        //given
        RankingCalculator calculator = new RankingCalculator();
        List<Integer> lastWeekWinning = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = initializeLottos();
        //when
        LottoResult lottoResult = calculator.calculate(lastWeekWinning, lottos, 1);
        //then
        assertThat(lottoResult).isEqualTo(new LottoResult(1, 0));
    }

    private Lottos initializeLottos() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 8, 11, 29)));
        lottos.add(new Lotto(Arrays.asList(2, 3, 6, 9, 10, 22)));
        lottos.add(new Lotto(Arrays.asList(2, 3, 5, 9, 17, 22)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 9, 10, 23, 44)));

        return lottos;
    }
}
