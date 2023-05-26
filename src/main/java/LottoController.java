import java.util.List;
import java.util.Set;

import domain.ManualRequest;
import view.LottoInputView;

public class LottoController {

    public static void main(String[] args) {
        int money = LottoInputView.getMoney();
        int manualCount = LottoInputView.getManualCount();
        List<Set<Integer>> manualNumbers = LottoInputView.getManualLottos(manualCount);
        LottoService lottoService = new LottoService();
        ManualRequest manualRequest = new ManualRequest(manualCount, manualNumbers);
        lottoService.playLottoGames(manualRequest, money);
        lottoService.lottoResults();
        lottoService.winningStatistics();
        lottoService.returnOnInvestment();
    }
}
