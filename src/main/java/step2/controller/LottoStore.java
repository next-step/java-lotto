package step2.controller;

import step2.lotto.Lotto;
import step2.lotto.client.Client;
import step2.lotto.LottoMachine;
import step2.lotto.Lottos;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final ResultView resultView;

    public LottoStore(ResultView resultView) {
        this.resultView = resultView;
    }

    public void sellTo(Client client) {
        long buyableLottoCount = client.buyableLottoCount();
        Lottos lottos = generateLottos(buyableLottoCount);
        client.buyLotto(lottos);
        printHowManyTicketClientBought(lottos);
    }

    private Lottos generateLottos(long count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoMachine.generateLotto();
            result.add(lotto);
        }
        return new Lottos(result);
    }

    private void printHowManyTicketClientBought(Lottos lottos) {
        String lottoReceipt = getLottoReceipt(lottos);
        resultView.print(lottoReceipt);
    }

    private String getLottoReceipt(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개를 구매했습니다", lottos.count()));
        sb.append("\n");
        sb.append(lottos.toString());
        return sb.toString();
    }

}
