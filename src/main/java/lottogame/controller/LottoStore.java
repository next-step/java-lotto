package lottogame.controller;

import static lottogame.model.lotto.LottoMachine.PER_LOTTO_PRICE;
import static lottogame.view.Casher.askBonusNum;
import static lottogame.view.Casher.askBuyPrice;
import static lottogame.view.Casher.askLottoNums;
import static lottogame.view.Casher.askManualLottos;
import static lottogame.view.Casher.informBuyCount;
import static lottogame.view.Casher.informPublishedLottos;
import static lottogame.view.Casher.informWinResult;

import java.util.Set;
import lottogame.model.lotto.LottoMachine;
import lottogame.model.lotto.LottoNum;
import lottogame.model.lotto.Lottos;
import lottogame.model.lotto.ManualLottos;
import lottogame.model.lotto.WinningLottoNums;
import lottogame.model.price.LottoPurchasePrice;
import lottogame.model.winner.WinnerResult;

public class LottoStore {

    public void start() {
        LottoPurchaseRequest lottoPurchaseRequest = getPurchaseInfosFromUser();

        Lottos lottos = buyLottos(lottoPurchaseRequest);

        WinnerResult winnerResult = lottos.compareAndElectWinResult(getWinningLottoNums());

        informWinResult(winnerResult, lottoPurchaseRequest.getRateOfReturn(winnerResult));
    }

    private LottoPurchaseRequest getPurchaseInfosFromUser() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(askBuyPrice());
        ManualLottos manualLottos = new ManualLottos(askManualLottos());

        informBuyCount(lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE),
                manualLottos.size());

        return new LottoPurchaseRequest(lottoPurchasePrice, manualLottos);
    }

    private Lottos buyLottos(LottoPurchaseRequest lottoPurchaseRequest) {
        Lottos autoLottos = LottoMachine.createAutoLotto(lottoPurchaseRequest.calculateAutoLottoCount(PER_LOTTO_PRICE));
        Lottos manualLotto = LottoMachine.createManualLotto(lottoPurchaseRequest.manualLottos());

        Lottos mergedLottos = autoLottos.merge(manualLotto);
        informPublishedLottos(mergedLottos.convertRawString());

        return mergedLottos;
    }

    private WinningLottoNums getWinningLottoNums() {
        Set<LottoNum> lottoByNums = LottoMachine.createLottoNums(askLottoNums());
        LottoNum bonusNum = LottoMachine.getLottoNum(askBonusNum());

        return new WinningLottoNums(lottoByNums, bonusNum);
    }
}
