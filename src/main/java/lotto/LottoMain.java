package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int paidAmount = LottoInputView.inputPaidAmount();
        int lottoCount = LottoTicketPrice.countByAmount(paidAmount);
        LottoResultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        LottoResultView.printLottoList(lottos.getLottos());

        System.out.println();
        List<Integer> winningLottoNumbers = LottoInputView.inputWinningNumbers();
        int bonusNumber = LottoInputView.inputBonusNumber();
        Lotto winningLotto = new Lotto(winningLottoNumbers, bonusNumber); //todo
        lottos.calculateAllMatchCount(winningLotto, new LottoNumber(bonusNumber));

        System.out.println();
        LottoResultView.printLottoStatistics(LottoWinningStatistics.getWinningLottoStatistics(lottos.getLottos()));
        LottoResultView.printLottoYield(LottoWinningStatistics.calculateRateOfReturn(LottoWinningStatistics.calculateTotalWinningAmount(lottos.getLottos()), paidAmount));
    }
}
