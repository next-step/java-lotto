import java.util.List;

import domain.ManualRequest;
import view.LottoInputView;

public class LottoMain {

    public static void main(String[] args) {
        int money = LottoInputView.getMoney();
        int manualCount = LottoInputView.getManualCount();
        List<List<Integer>> manualNumbers = LottoInputView.getManualLottos(manualCount);
        LottoController lottoController = new LottoController();
        ManualRequest manualRequest = new ManualRequest(manualCount, manualNumbers);
        lottoController.playLottoGames(manualRequest, money);
        lottoController.getLottoResults();
        lottoController.getWinningStatistics();
        lottoController.getReturnOnInvestment();
    }
}
