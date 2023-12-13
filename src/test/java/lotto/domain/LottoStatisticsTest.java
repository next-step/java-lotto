package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoStatisticsTest {

    @Test
    @DisplayName("랭크를 기록한 데이터를 반환한다")
    void statistics() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);

        Lotto lotto = new Lotto(winningNumbers);
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(new Lotto(lottoNumbers));
        LottoStatistics lottoStatistics = new LottoStatistics();
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        lottoTicket.match(lottoMachine, winningLotto, lottoStatistics);

        Assertions.assertThat(lottoStatistics.getLottoStatistics().get(Rank.FOURTH)).isEqualTo(1);
    }
}
