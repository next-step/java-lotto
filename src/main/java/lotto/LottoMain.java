package lotto;

public class LottoMain {
    public static void main(String[] args) {
        int paidAmount = LottoInputView.inputPaidAmount();
        int lottoCount = LottoTicket.countByAmount(paidAmount);
        LottoResultView.printLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        LottoResultView.printLottoList(lottos.getLottos());

        System.out.println();
        lottos.calculateAllMatchCount(LottoInputView.inputWinningNumbers());

        System.out.println();
        LottoResultView.printLottoStatistics(LottoWinningStatistics.getWinningLottoStatistics(lottos.getLottos()));
        LottoResultView.printLottoYield(LottoWinningStatistics.calculateRateOfReturn(LottoWinningStatistics.calculateTotalWinningAmount(lottos.getLottos()), paidAmount));
    }
}
