package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoViewController {

    private final static int LOTTO_PRICE = 1000;

    private final InputView inputView;
    private final ResultView resultView;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoViewController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void execute() {
        inputView.inputPurchasePrice(this);
    }

    public void setPurchasePrice(int purchasePrice) {
        int count = purchasePrice / LOTTO_PRICE;
        lottos.clear();
        lottos.addAll(LottoFactory.createLotto(count));
        showLottoNumbers(count);

        inputView.inputLastWeekWinningNumbers(this);
    }

    public void setLastWeekWinningNumbers(String input) {
        lottos.forEach(lotto -> lotto.checkMatchingNumbers(LottoFactory.getLastWeekWinningNumbers(input)));
    }

    private void showLottoNumbers(int count) {
        resultView.showNumberOfLotto(count);
        lottos.forEach(lotto -> resultView.showLottos(lotto.getLottoNumbers()));
    }
}
