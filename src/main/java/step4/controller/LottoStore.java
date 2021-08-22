package step4.controller;

import step4.lotto.Lotto;
import step4.lotto.LottoMachine;
import step4.lotto.LottoNumber;
import step4.lotto.Lottos;
import step4.lotto.client.Client;
import step4.lotto.exception.NotEnoughMoneyException;
import step4.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {

    private final ResultView resultView;

    public LottoStore(ResultView resultView) {
        this.resultView = resultView;
    }

    public void sellTo(Client client) {
        Lottos lottos = Lottos.empty();

        Lottos manualLottos = generateManualLottos(client);
        long automaticLottoCount = client.buyableLottoCount() - manualLottos.count();
        Lottos automaticLottos = LottoMachine.generateLottos(automaticLottoCount);

        lottos.addAll(manualLottos);
        lottos.addAll(automaticLottos);

        client.buyLotto(lottos);
        resultView.printHowManyTicketClientBought(manualLottos, automaticLottos);
    }

    private Lottos generateManualLottos(Client client) {
        List<LottoNumber> manualLottoNumbers = client.getManualLottoNumbers();

        List<Lotto> manualLottos = manualLottoNumbers.stream()
                .map(LottoMachine::generateLotto)
                .collect(Collectors.toList());

        return new Lottos(manualLottos);
    }
}
