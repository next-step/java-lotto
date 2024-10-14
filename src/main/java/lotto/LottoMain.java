package lotto;

import lotto.constant.Prize;
import lotto.domain.CashAmount;
import lotto.domain.Lotto;
import lotto.domain.LottoCreateByMission;
import lotto.domain.LottoMachine;
import lotto.domain.ManualAmount;
import lotto.domain.MissionProfitRateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;


public class LottoMain {

    public static void main(String[] args) {
        // 로또 구입
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
//        inputView.printPurchaseCount(machine.calculatePurchaseQuantity());

        // 로또 생성
        int cashAmount = inputView.getCashAmount();
        List<Lotto> manualLottoList = inputView.getManualLottoNumbers(inputView.getManualLottoCount());
        LottoMachine machine = LottoMachine.of(new CashAmount(cashAmount), new ManualAmount(manualLottoList.size())
                , new MissionProfitRateStrategy(), new LottoCreateByMission());
        resultView.printLottoAmount(manualLottoList.size(), machine.calculatePurchaseQuantity());
        List<Lotto> autoLottoList = machine.createAutomatically();

        manualLottoList.addAll(autoLottoList);
        // 로또 출력
        resultView.printLottoNumbers(autoLottoList);

        // 과거 당첨 번호 입력
        Set<Integer> winningNumbers = inputView.getWinningNumbers();

        // 보너스 볼 입력
        int bonusNumber = inputView.getBonusNumber();

        // 당첨 확인
        EnumMap<Prize, Integer> countMap = machine.checkLottoPrize(manualLottoList, winningNumbers, bonusNumber);

        // 결과 출력
        String profitRate = machine.calculateProfitRate(countMap);
        resultView.printResult(countMap, profitRate);
    }

}
