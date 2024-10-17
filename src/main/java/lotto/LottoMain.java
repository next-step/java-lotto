package lotto;

import lotto.constant.Prize;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoCreateByMission;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNo;
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

        // 로또 생성
        int cashAmount = inputView.getCashAmount();
        List<Lotto> manualLottoList = inputView.getManualLottoNumbers(inputView.getManualLottoCount());
        LottoMachine machine = LottoMachine.builder().cashAmount(new Amount(cashAmount))
                .manualAmount(new Amount(manualLottoList.size()))
                .profitRateStrategy(new MissionProfitRateStrategy())
                .lottoCreateStrategy(new LottoCreateByMission())
                .build();
        List<Lotto> autoLottoList = machine.createAutomatically();

        manualLottoList.addAll(autoLottoList);
        // 로또 출력
        resultView.printLottoNumbers(autoLottoList);

        // 과거 당첨 번호 입력
        Set<LottoNo> winningNumbers = inputView.getWinningNumbers();

        // 보너스 볼 입력
        LottoNo bonusNumber = inputView.getBonusNumber();

        // 당첨 확인
        EnumMap<Prize, Integer> countMap = machine.checkLottoPrize(manualLottoList, winningNumbers, bonusNumber);

        // 결과 출력
        String profitRate = machine.calculateProfitRate(countMap);
        resultView.printResult(countMap, profitRate);
    }

}
