package lottoTest;

import lotto.model.ResultLotto;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("1000원으로 구매한 로또 수는 1개이다.")
    void buyLottosTest() {
        ResultLotto resultLotto = lottoService.buyLottos(1000);
        Assertions.assertThat(resultLotto.totallottoCount()).isEqualTo(1);
    }

    @Test
    void checkLottoResultTest() {
        LottoService lottoService = new LottoService();
        ResultLotto resultLotto;

        lottoService.buyLottos(140000);
        resultLotto = lottoService.checkLottoResult(List.of(1, 2, 3, 4, 5, 6), 7);

        int buyCount = resultLotto.totallottoCount();
        int winningAmount = resultLotto.getWinningAmount();

        System.out.println(resultLotto.getWinningRate());
        System.out.println(winningAmount / buyCount * 1000);

        Assertions.assertThat(resultLotto.getWinningRate()).isEqualTo(winningAmount / (buyCount * 1000));
    }
}
