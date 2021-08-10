package step2.controller;

import step2.lotto.LottoMachine;
import step2.lotto.Lottos;
import step2.lotto.client.Client;
import step2.view.ResultView;

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
