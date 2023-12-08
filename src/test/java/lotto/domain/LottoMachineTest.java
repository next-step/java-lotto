package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoMachineTest {
    @Test
    @DisplayName("로또 머신은 로또티켓을 만들 수 있다.")
    void generateLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(3);
        Assertions.assertThat(lottoTicket.getLottoTicket()).hasSize(3);
    }

    @Test
    @DisplayName("당첨로또와 로또를 비교하여 Rank를 선정할 수 있다")
    void rank() {
        List<LottoNumber> lottoNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        List<LottoNumber> lottoNumbers2 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lotto lotto1 = new Lotto(lottoNumbers1);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        LottoMachine lottoMachine = new LottoMachine();
        LottoStatistics lottoStatistics = new LottoStatistics();
        Rank rank = lottoMachine.rank(lotto1, lotto2, lottoStatistics);
        Assertions.assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
