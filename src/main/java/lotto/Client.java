package lotto;

import java.util.List;

public class Client {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoStore lottoStore = new LottoStore();

        List<Lotto> lottos = lottoStore.buyLotto(inputView.priceView());
        resultView.lottoSizeResultView(lottos.size());
        resultView.lottoNumbersView(lottos);

        List<LottoNumber> winnerNumbers = inputView.winnerNumbersView();
        resultView.reportView(lottos,winnerNumbers);


    }
}
