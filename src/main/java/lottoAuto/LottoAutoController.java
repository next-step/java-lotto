package lottoAuto;

import lottoAuto.model.*;
import lottoAuto.view.InputView;
import lottoAuto.view.ResultView;

public class LottoAutoController {

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int amount = LottoCalculator.calculateAmount(price);
        ResultView.showAmount(amount);

        Lottos lottos = makeLottos(amount);
        ResultView.showUserLotto(lottos);

        WinningLotto winningLotto = makeWinningLotto();
        LottoResults lottoResults = lottos.matchWinningLotto(winningLotto);

        Revenue revenue = new Revenue(lottoResults.lottoRankCounting(),price);
        ResultView.showWinningStatistic(revenue);
        ResultView.showRevenue(revenue.calculateRevenue());
    }

    private static Lottos makeLottos(int amount){
        LottoGenerator lottoGenerator = new LottoGenerator(amount);

        return new Lottos(lottoGenerator.getLottos());
    }

    private static WinningLotto makeWinningLotto(){
        String winningLottoNumber = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();

        return new WinningLotto(StringUtil.makeLotto(winningLottoNumber), bonusBall);
    }
}