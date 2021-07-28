package lotto;

import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.util.DivisionNumber;
import lotto.view.DosInputView;
import lotto.view.DosResultView;
import lotto.view.InputView;
import lotto.view.ResultView;

public final class LottoSolution {
    public static void main(String[] args) {
        LottoSolution lottoSolution = new LottoSolution(
                new DosInputView(), new DosResultView()
        );
        lottoSolution.run();
    }

    private final InputView inputView;
    private final ResultView resultView;

    private static final Money LOTTO_PRICE = new Money(1000);

    public LottoSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            int money = inputView.inputMoney();
            LottoList lottoList = buyLotto(money);
        } catch (Exception e) {
            resultView.printException(e);
        }
    }

    private LottoList buyLotto(int intMoney) {
        Money money = new Money(intMoney);
        DivisionNumber lottoSize = new DivisionNumber(money, LOTTO_PRICE);
        return LottoList.newAuto(lottoSize);
    }
}
