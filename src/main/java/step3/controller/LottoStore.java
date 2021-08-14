package step3.controller;

import step3.lotto.LottoMachine;
import step3.lotto.Lottos;
import step3.lotto.client.Client;
import step3.view.ResultView;

public class LottoStore {

    private final ResultView resultView;

    public LottoStore(ResultView resultView) {
        this.resultView = resultView;
    }

    public void sellTo(Client client) {
        long buyableLottoCount = client.buyableLottoCount();
        Lottos lottos = LottoMachine.generateLottos(buyableLottoCount);
        client.buyLotto(lottos);
        resultView.printHowManyTicketClientBought(lottos);
    }
}
