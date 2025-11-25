package lottoGame.controller;

import static lottoGame.view.Casher.askBeforeWinNums;
import static lottoGame.view.Casher.askBuyPrice;
import static lottoGame.view.Casher.informBuyCount;
import static lottoGame.view.Casher.informPublishedLottos;
import static lottoGame.view.Casher.informWinResult;

import java.util.List;
import lottoGame.model.lotto.Lotto;
import lottoGame.model.lotto.LottoMachine;
import lottoGame.model.lotto.LottoNum;
import lottoGame.model.lotto.Lottos;
import lottoGame.model.price.BuyPrice;
import lottoGame.model.winner.WinnerResult;
import lottoGame.view.WinResultDto;

public class LottoStore {

    public static final int PER_LOTTO_PRICE = 1_000;

    public void start() {
        BuyPrice buyPrice = getBuyPrice();
        LottoMachine lottoMachine = new LottoMachine(PER_LOTTO_PRICE);

        Lottos lottos = buyLottos(
                lottoMachine,
                buyPrice
        );

        totalWinResult(
                getBeforeWinLotto(lottoMachine),
                lottos,
                buyPrice.price(),
                new LottoNum(7)
        );
    }

    private Lottos buyLottos(LottoMachine lottoMachine, BuyPrice buyPrice) {
        Lottos lottos = lottoMachine.publish(buyPrice);
        informPublishedLottos(lottos.convertRawString());
        return lottos;
    }


    private BuyPrice getBuyPrice() {
        BuyPrice buyPrice = new BuyPrice(askBuyPrice());
        informBuyCount(buyPrice.calculateLottoCount(PER_LOTTO_PRICE));

        return buyPrice;
    }

    private Lotto getBeforeWinLotto(LottoMachine lottoMachine) {
        List<LottoNum> lottoByNums = lottoMachine.createLottoByNums(askBeforeWinNums());

        return new Lotto(lottoByNums);
    }

    private void totalWinResult(
            Lotto beforeWinLotto,
            Lottos lottos,
            int price,
            LottoNum bonusNum
    ) {
        WinnerResult winnerResult = lottos.compareAndElectWinResult(
                beforeWinLotto,
                bonusNum
        );

        informWinResult(
                new WinResultDto(
                        winnerResult,
                        price
                )
        );
    }

}
