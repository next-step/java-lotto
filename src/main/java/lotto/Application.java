package lotto;

import lotto.application.LottoIssueResponse;
import lotto.application.LottoMachine;
import lotto.ui.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoMachine());
        LottoIssueResponse issueResponse = lottoController.issueLottos();
        lottoController.rankLottos(issueResponse.getLottos());
    }
}
