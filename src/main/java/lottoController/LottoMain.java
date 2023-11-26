package lottoController;


import lottoModel.Lotto;
import lottoModel.LottoInputValue;
import lottoModel.LottoResult;
import lottoView.InputView;
import lottoView.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int gameCount = LottoDomain.countGame(money);
        int manualCount = InputView.inputLottoManualNumber();
        int autoCount = gameCount - manualCount;

        /**
         *  수동 로또 번호 입력
         */
        LottoInputValue manualInputValue = InputView.manualLottoNumbers();
        List<Lotto> manualLottos = manualInputValue.convertManualLottoNumbers(manualCount);


        ResultView.resultCount(manualCount, autoCount);
        List<Lotto> lottos = LottoDomain.createLottoGames(autoCount);
        ResultView.printLottoNumber(lottos);

        LottoInputValue lottoInputValue = InputView.lastLottoNumbers();
        Set<Integer> lastLotto = lottoInputValue.convertLastLottoNumbers();

        LottoInputValue lottoInputBonusNumber = InputView.inputLottoBonusNumber();
        int lottoBonusNumber = lottoInputBonusNumber.convertLottoBonusNumbers(lastLotto);

        lottos.addAll(manualLottos);

        LottoResult lottoResult = LottoResult.result(money, lottos, new ArrayList<>(lastLotto), lottoBonusNumber);
        ResultView.printLottoResult(lottoResult);
    }

}
