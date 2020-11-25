package lotto;

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
        int count = purchasePrice / 1000;

        lottoViewController.setPurchasePrice(purchasePrice);

        assertThat(LottoFactory.createLotto(count).size()).isEqualTo(14);
    }

    @Test
    void setLastWeekWinningNumbers() {
        String input = "1, 2, 3, 4, 5, 6";
        lottoViewController.setLastWeekWinningNumbers(input);
        assertThat(LottoFactory.getLastWeekWinningNumbers(input));
    }
}
