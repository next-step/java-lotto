package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStatics;

import java.util.ArrayList;
import java.util.List;

public class LottoViewController {

    private final static int LOTTO_PRICE = 1000;
    private final static int MIN_WINNING_COUNT = 3;

    private final InputView inputView;
    private final ResultView resultView;
    private final List<Lotto> lottos = new ArrayList<>();
    private int purchasePrice = 0;

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

        this.purchasePrice = purchasePrice;

        inputView.inputLastWeekWinningNumbers(this);
    }

    public void setLastWeekWinningNumbers(String input) {
        lottos.forEach(lotto -> lotto.checkMatchingNumbers(LottoFactory.getLastWeekWinningNumbers(input)));
        lottos.stream()
                .map(Lotto::getMatchCnt)
                .filter(count -> count >= MIN_WINNING_COUNT)
                .forEach(LottoStatics::setLottoStatics);

        resultView.showWinStatics(
                LottoStatics.values(),
                (double) LottoStatics.getWinningPrize() / purchasePrice);
    }

    private void showLottoNumbers(int count) {
        resultView.showNumberOfLotto(count);
        lottos.forEach(lotto -> resultView.showLottos(lotto.getLottoNumbers()));
    }
}
