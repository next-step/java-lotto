package step2.controller;

import step2.model.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Lotto> manualLottoList;

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String amount = inputView.ask("구입금액을 입력해 주세요.");
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        String manualLottoCount = inputView.ask("수동으로 구매할 로또 수를 입력해 주세요.");
        LottoCount lottoCount = new LottoCount(purchaseAmount, manualLottoCount);

        manualLottoList = new ArrayList<>();
        if (lottoCount.getManualLottoCount() > 0) {
            askManualLottoNumbers(inputView, lottoCount);
        }

        LottoGroup manualLottoGroup = new LottoGroup(manualLottoList);
        LottoGroup autoLottoGroup = new LottoGroup(new AutoLottoStrategy(), lottoCount.getAutoLottoCount());

        System.out.println("수동으로 " + lottoCount.getManualLottoCount() + "장, 자동으로 " + lottoCount.getAutoLottoCount() + "개를 구매했습니다.");

        ResultView view = new ResultView();
        view.showLotto(manualLottoGroup.getLottoResult());
        view.showLotto(autoLottoGroup.getLottoResult());

        String winningNo = inputView.ask("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningNumber = new Lotto(winningNo);

        String bonusNumber = inputView.ask("보너스 볼을 입력해 주세요.");
        Bonus bonus = new Bonus(winningNumber, bonusNumber);

        Winning winning = new Winning(winningNumber, bonus);

        List<Lotto> allLottoList = manualLottoGroup.combineGroup(manualLottoGroup, autoLottoGroup);
        LottoGroup totalGroup = new LottoGroup(allLottoList);

        Result winningResult = new Result();
        Map<Rank, Integer> result = winningResult.getResult(totalGroup, winning);
        String winningRate = winningResult.getWinningRate(purchaseAmount, result);
        view.showResult(result, winningRate);
    }

    private static void askManualLottoNumbers(InputView inputView, LottoCount lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        while (true) {
            String manualLotto = inputView.getInput();
            manualLottoList.add(new Lotto(manualLotto));
            boolean equalsCount = lottoCount.isEqualsManualCount(manualLottoList.size());
            if(equalsCount) break;
        }
    }


}
