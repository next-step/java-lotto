package lotto;

public class LottoMain {
    public static void main(String[] args) {
        int paidAmount = LottoInputView.inputPaidAmount();
        int lottoCount = LottoTicketPrice.countByAmount(paidAmount);
        LottoResultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        LottoResultView.printLottoList(lottos.getLottos());

        System.out.println();
        Lotto winningLotto = LottoInputView.inputWinningNumbers();
        int bonusNumber = LottoInputView.inputBonusNumber(winningLotto.getLottoNumbers());
        lottos.calculateAllMatchCount(winningLotto, bonusNumber);

        System.out.println();
        //todo
//        LottoResultView.printLottoStatistics(LottoWinningStatistics.getWinningLottoStatistics(lottos.getLottos()));
        LottoResultView.printLottoYield(LottoWinningStatistics.calculateRateOfReturn(LottoWinningStatistics.calculateTotalWinningAmount(lottos.getLottos()), paidAmount));
    }
}
