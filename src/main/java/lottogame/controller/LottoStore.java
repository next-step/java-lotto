package lottogame.controller;

import static lottogame.view.Casher.askBeforeWinNums;
import static lottogame.view.Casher.askBonusNum;
import static lottogame.view.Casher.askBuyPrice;
import static lottogame.view.Casher.informBuyCount;
import static lottogame.view.Casher.informPublishedLottos;
import static lottogame.view.Casher.informWinResult;

import java.util.Set;
import lottogame.model.lotto.Lotto;
import lottogame.model.lotto.LottoMachine;
import lottogame.model.lotto.LottoNum;
import lottogame.model.lotto.Lottos;
import lottogame.model.lotto.WinningLottoNums;
import lottogame.model.price.LottoPurchasePrice;
import lottogame.model.winner.WinnerResult;

public class LottoStore {

    public static final int PER_LOTTO_PRICE = 1_000;

    public void start() {
        LottoPurchasePrice lottoPurchasePrice = getLottoPurchasePrice();
        LottoMachine lottoMachine = new LottoMachine(PER_LOTTO_PRICE);

        Lottos lottos = buyLottos(lottoMachine, lottoPurchasePrice);

        WinnerResult winnerResult = lottos.compareAndElectWinResult(
                getWinningLottoNums(lottoMachine));

        informWinResult(winnerResult, lottoPurchasePrice.price());
    }

    private LottoPurchasePrice getLottoPurchasePrice() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(askBuyPrice());
        informBuyCount(lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE));

        return lottoPurchasePrice;
    }

    private Lottos buyLottos(LottoMachine lottoMachine, LottoPurchasePrice lottoPurchasePrice) {
        Lottos lottos = lottoMachine.publish(lottoPurchasePrice);
        informPublishedLottos(lottos.convertRawString());
        return lottos;
    }

    private WinningLottoNums getWinningLottoNums(LottoMachine lottoMachine) {
        Set<LottoNum> lottoByNums = lottoMachine.createLottoByNums(askBeforeWinNums());
        int bonusNum = askBonusNum();

        return new WinningLottoNums(new Lotto(lottoByNums), new LottoNum(bonusNum));
    }
}
