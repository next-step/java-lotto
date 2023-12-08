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
        List<LottoNumber> winningNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9));

        Lotto winningLotto = new Lotto(winningNumbers);
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(new Lotto(lottoNumbers));
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoTicket.match(lottoMachine, winningLotto, lottoStatistics);

        Assertions.assertThat(lottoStatistics.getLottoStatistics().get(Rank.FOURTH)).isEqualTo(1);
    }
}
