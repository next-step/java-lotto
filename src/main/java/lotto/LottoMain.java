package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int paidAmount = LottoInputView.inputPaidAmount();
        int lottoCount = LottoTicket.countByAmount(paidAmount);
        LottoResultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        LottoResultView.printLottoList(lottos.getLottos());

        System.out.println();
        List<Integer> winningLotto = LottoInputView.inputWinningNumbers();
        lottos.calculateAllMatchCount(winningLotto);

        System.out.println();
        LottoResultView.printLottoStatistics(LottoWinningStatistics.getWinningLottoStatistics(lottos.getLottos())); //todo
        LottoResultView.printLottoYield(LottoWinningStatistics.calculateRateOfReturn(LottoWinningStatistics.calculateTotalWinningAmount(lottos.getLottos()), paidAmount));
    }
}
