package raffle.lotto.play;

import raffle.lotto.LottoBuy;
import raffle.lotto.LottoMachine;
import raffle.lotto.validator.LottoNumberValidator;
import raffle.lotto.win.LottoResult;
import raffle.view.InputView;
import raffle.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        LottoBuy lottoBuy = new LottoBuy(InputView.buyLotto() , InputView.lottoAmount());
        LottoMachine lottoMachine = new LottoMachine(lottoBuy.getAmout() ,InputView.getLottoNumber(lottoBuy.getCount()), new LottoNumberValidator());
        resultView.buyLotto(lottoMachine.getLottos(), lottoBuy.getCount());

        LottoResult lottoResult = lottoMachine.winLotto(InputView.lastWeekLotto(), InputView.bonusLotto());
        resultView.result(lottoResult);

    }
}
