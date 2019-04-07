package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameResultTest {

    @Test
    public void multipleResultsTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6),44);
        List<Lotto> userLottos = new ArrayList<>();

        Lotto userLotto1 = new Lotto(Arrays.asList(1,2,3,4,5,8));
        Lotto userLotto2 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        userLottos.add(userLotto1);
        userLottos.add(userLotto2);

        LottoGameResult result = new LottoGameResult();
        result.getMultipleResults(winningLotto, userLottos);

        assertThat(result.getWinningCountOfResult(LottoProfit.FIRST)).isEqualTo(1);
        assertThat(result.getWinningCountOfResult(LottoProfit.SECOND)).isEqualTo(0);
        assertThat(result.getWinningCountOfResult(LottoProfit.THIRD)).isEqualTo(1);


    }
}
