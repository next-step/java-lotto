package raffle.lotto.play;

import raffle.lotto.LottoBuyConut;
import raffle.lotto.LottoMachine;
import raffle.lotto.money.Money;
import raffle.lotto.validator.LottoNumberValidator;
import raffle.lotto.win.LottoResult;
import raffle.view.InputView;
import raffle.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        LottoBuyConut lottoBuyConut = InputView.buyLotto();
        LottoMachine lottoMachine = new LottoMachine(InputView.lottoAmount() ,InputView.getLottoNumber(lottoBuyConut.getCount()), new LottoNumberValidator());
        resultView.buyLotto(lottoMachine.getLottos(), lottoBuyConut.getCount());

        LottoResult lottoResult = lottoMachine.winLotto(InputView.lastWeekLotto(), InputView.bonusLotto());
        resultView.result(lottoResult);

    }
}
