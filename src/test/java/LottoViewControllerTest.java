import lotto.InputView;
import lotto.LottoViewController;
import lotto.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoViewControllerTest {

    private LottoViewController lottoViewController;
    private InputView inputView;
    private ResultView resultView;

    @BeforeEach
    void setup() {
        inputView = new InputView();
        resultView = new ResultView();
        lottoViewController = new LottoViewController(inputView, resultView);
    }

    @Test
    void setPurcashPriceTest() {
        int purchasePrice = 14000;
        lottoViewController.setPurchasePrice(purchasePrice);
//        List<Lotto> lottos = LottoFactory.createLotto(14000 / 1000);
        assertThat(lottoViewController.getLottos().size()).isEqualTo(14);
    }
}
