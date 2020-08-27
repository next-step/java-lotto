package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoResult;
import step2.domain.Lottos;
import step2.domain.WinningLottoNumbers;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    void ticketTest() {
        Lottos lottos = Lotto.create(1);
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers("10,1,31,27,19,20");
        LottoResult lottoResult = lottos.getMatching(winningLottoNumbers);
        assertThat(lottoResult.getResultMap().size() <= 4).isTrue();
    }
}
