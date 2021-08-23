package step2.controller;

import step2.model.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static step2.model.LottoGroup.*;
import static step2.model.LottoValidator.changeToInt;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String amount = inputView.ask("구입금액을 입력해 주세요.");
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        String lottoCount = inputView.ask("수동으로 구매할 로또 수를 입력해 주세요.");
        PurchaseAmount leftAmount = purchaseAmount.calcPurchaseAmount(lottoCount);
        int manualLottoCount = changeToInt(lottoCount);
        int autoLottoCount = leftAmount.getLottoCount();

        List<Lotto> manualLottoList = new ArrayList<>();
        if (manualLottoCount > 0) {
            manualLottoList = inputView.askManualLottoNumbers(manualLottoCount);
        }

        LottoGroup manualLottoGroup = purchaseManualLotto(manualLottoList);
        LottoGroup autoLottoGroup = purchaseAutoLotto(new AutoLottoStrategy(), autoLottoCount);

        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");

        ResultView view = new ResultView();
        view.showLotto(manualLottoGroup.getLottoResult());
        view.showLotto(autoLottoGroup.getLottoResult());

        String winningNumber = inputView.ask("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLotto = new Lotto(winningNumber);

        String bonusNumber = inputView.ask("보너스 볼을 입력해 주세요.");
        Bonus bonus = new Bonus(winningLotto, bonusNumber);

        Winning winning = new Winning(winningLotto, bonus);

        LottoGroup totalGroup = combineGroup(manualLottoGroup, autoLottoGroup);

        Result winningResult = new Result();
        Map<Rank, Integer> result = winningResult.getResult(totalGroup, winning);
        String winningRate = winningResult.getWinningRate(purchaseAmount, result);
        view.showResult(result, winningRate);
    }

}
