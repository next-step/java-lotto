package lottogame.controller;

import static lottogame.model.lotto.LottoMachine.PER_LOTTO_PRICE;
import static lottogame.view.Casher.askBeforeWinNums;
import static lottogame.view.Casher.askBonusNum;
import static lottogame.view.Casher.askBuyPrice;
import static lottogame.view.Casher.informBuyCount;
import static lottogame.view.Casher.informPublishedLottos;
import static lottogame.view.Casher.informWinResult;

import java.util.Set;
import lottogame.model.lotto.LottoMachine;
import lottogame.model.lotto.LottoNum;
import lottogame.model.lotto.Lottos;
import lottogame.model.lotto.WinningLottoNums;
import lottogame.model.price.LottoPurchasePrice;
import lottogame.model.winner.WinnerResult;

public class LottoStore {

    public void start() {
        LottoPurchasePrice lottoPurchasePrice = getLottoPurchasePrice();

        Lottos lottos = buyLottos(lottoPurchasePrice);

        WinnerResult winnerResult = lottos.compareAndElectWinResult(getWinningLottoNums());

        informWinResult(winnerResult, lottoPurchasePrice);
    }

    private LottoPurchasePrice getLottoPurchasePrice() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(askBuyPrice());
        informBuyCount(lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE));

        return lottoPurchasePrice;
    }

    private Lottos buyLottos(LottoPurchasePrice lottoPurchasePrice) {
        Lottos lottos = LottoMachine.makeLotto(lottoPurchasePrice);
        informPublishedLottos(lottos.convertRawString());
        return lottos;
    }

    private WinningLottoNums getWinningLottoNums() {
        Set<LottoNum> lottoByNums = LottoMachine.createLottoByNums(askBeforeWinNums());
        LottoNum bonusNum = LottoMachine.getLottoNum(askBonusNum());

        return new WinningLottoNums(lottoByNums, bonusNum);
    }
}
