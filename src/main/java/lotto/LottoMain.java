package lotto;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int paidAmount = LottoInputView.inputPaidAmount();
        int lottoCount = Lottos.countByAmount(paidAmount);
        LottoResultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        LottoResultView.printLottoList(lottos.getLottos());

        System.out.println();
        List<Integer> winningLotto = LottoInputView.inputWinningNumbers();
        lottos.getAllMatchCount(winningLotto);

        System.out.println();
        LottoResultView.printLottoStatistics(lottos.getWinningLottoStatistics());
        LottoResultView.printLottoYield(lottos.calculateRateOfReturn(lottos.calculateTotalWinningAmount(), paidAmount));
    }
}
