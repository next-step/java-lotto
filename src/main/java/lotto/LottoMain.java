package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int paidAmount = LottoInputView.inputPaidAmount();

        int lottoCount = LottoTicketValidator.countByAmount(paidAmount);
        int manualLottoCount = LottoInputView.inputManualLottoCount(lottoCount);
        Lottos manualLottos = LottoInputView.inputAllManualLottos(manualLottoCount);

        LottoResultView.printLottoCount(manualLottoCount, lottoCount - manualLottoCount);

        Lottos allLottos = new Lottos(manualLottos);
        allLottos.addAll(new Lottos(lottoCount - manualLottoCount));
        LottoResultView.printLottoList(allLottos.getValues());

        System.out.println();
        List<Integer> winningLottoNumbers = LottoInputView.inputWinningNumbers();
        int bonusNumber = LottoInputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
        allLottos.calculateAllMatchCount(winningLotto);

        System.out.println();
        LottoResultView.printLottoStatistics(LottoWinningStatistics.getWinningLottoStatistics(allLottos.getValues()));
        LottoResultView.printLottoYield(LottoWinningStatistics.calculateRateOfReturn(LottoWinningStatistics.calculateTotalWinningAmount(allLottos.getValues()), paidAmount));
    }
}
