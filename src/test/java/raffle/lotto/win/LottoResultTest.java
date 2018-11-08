package raffle.lotto.win;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static raffle.lotto.LottoMachine.LOTTO_PRICE;
import static raffle.lotto.win.WinLotto.*;

public class LottoResultTest {

    @Test
    public void 로또_당첨_개수() {
        List<WinLotto> winLottos = Arrays.asList(FIVE_WIN_LOTTO, THREE_WIN_LOTTO, FIVE_WIN_LOTTO);
        LottoResult lottoResult = new LottoResult(winLottos, LOTTO_PRICE);
        assertThat(lottoResult.getLottoCount(FIVE_WIN_LOTTO)).isEqualTo(2);
    }

    @Test
    public void 로또_수익() {
        List<WinLotto> winLottos = Arrays.asList(THREE_WIN_LOTTO, ONE_LOTTO, ONE_LOTTO, TWO_LOTTO, ONE_LOTTO, ONE_LOTTO, TWO_LOTTO, ONE_LOTTO, ONE_LOTTO, TWO_LOTTO);
        LottoResult lottoResult = new LottoResult(winLottos, LOTTO_PRICE);
        assertThat(lottoResult.getResultProfit()).isEqualTo(0.5);
    }

}