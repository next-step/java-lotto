import java.util.List;

import view.LottoInputView;

public class LottoMain {

    public static void main(String[] args) {
        int money = LottoInputView.getMoney();
        int manualCount = LottoInputView.getManualCount();
        List<int[]> manualNumbers = LottoInputView.getManualNumbers(manualCount);
        LottoController lottoController = new LottoController();
        lottoController.playLottoGames(money);
        lottoController.getLottoResults();
        lottoController.getWinningStatistics();
        lottoController.getReturnOnInvestment();
    }
}
