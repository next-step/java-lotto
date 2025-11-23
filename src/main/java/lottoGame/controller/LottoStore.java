package lottoGame.controller;

import static lottoGame.view.Casher.askBeforeWinNums;
import static lottoGame.view.Casher.askBuyPrice;
import static lottoGame.view.Casher.informBuyCount;
import static lottoGame.view.Casher.informPublishedLottos;
import static lottoGame.view.Casher.informWinningLottoNums;

import lottoGame.model.lotto.LottoMachine;
import lottoGame.model.lotto.Lottos;
import lottoGame.model.price.BuyPrice;
import lottoGame.model.winner.BeforeWinNums;
import lottoGame.model.winner.WinnerResult;
import lottoGame.view.WinResultDto;

public class LottoStore {
    public static final int PER_LOTTO_PRICE = 1000;

    public void start() {
        BuyPrice buyPrice = getBuyPrice();

        Lottos lottos = buyLottos(buyPrice);

        totalWinResult(
                new BeforeWinNums(askBeforeWinNums()),
                lottos,
                buyPrice.price()
        );
    }

    private Lottos buyLottos(BuyPrice buyPrice) {
        Lottos lottos = publishLottos(buyPrice);
        informPublishedLottos(lottos.convertRawString());
        return lottos;
    }

    private BuyPrice getBuyPrice() {
        BuyPrice buyPrice = new BuyPrice(askBuyPrice());
        informBuyCount(buyPrice.calculateLottoCount(PER_LOTTO_PRICE));

        return buyPrice;
    }

    private Lottos publishLottos(BuyPrice buyPrice) {
        LottoMachine lottoMachine = new LottoMachine(PER_LOTTO_PRICE);

        return lottoMachine.publish(buyPrice);
    }

    private void totalWinResult(BeforeWinNums beforeWinNums, Lottos lottos, int price) {
        WinnerResult winnerResult = lottos.compareAndElectWinResult(beforeWinNums);

        informWinningLottoNums(
                new WinResultDto(
                        winnerResult,
                        price
                )
        );
    }

}
