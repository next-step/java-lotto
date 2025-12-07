package lottogame.controller;

import static lottogame.model.lotto.LottoMachine.PER_LOTTO_PRICE;
import static lottogame.model.lotto.LottoNum.of;
import static lottogame.view.Casher.askBonusNum;
import static lottogame.view.Casher.askBuyPrice;
import static lottogame.view.Casher.askLottoNums;
import static lottogame.view.Casher.askManualLottos;
import static lottogame.view.Casher.informBuyCount;
import static lottogame.view.Casher.informPublishedLottos;
import static lottogame.view.Casher.informWinResult;

import java.util.List;
import java.util.Set;
import lottogame.model.lotto.LottoMachine;
import lottogame.model.lotto.LottoNum;
import lottogame.model.lotto.Lottos;
import lottogame.model.lotto.WinningLottoNums;
import lottogame.model.lotto.generator.LottosGenerator;
import lottogame.model.price.LottoPurchasePrice;
import lottogame.model.winner.WinnerResult;

public class LottoStore {
    public static final int PER_LOTTO_PRICE = 1_000;

    public void start() {
        LottoPurchaseRequest lottoPurchaseRequest = getPurchaseInfosFromUser();

        Lottos lottos = buyLottos(lottoPurchaseRequest);

        WinnerResult winnerResult = lottos.compareAndElectWinResult(getWinningLottoNums());

        informWinResult(winnerResult, lottoPurchaseRequest.getRateOfReturn(winnerResult));
    }

    private LottoPurchaseRequest getPurchaseInfosFromUser() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(askBuyPrice());
        List<String> manualLottos = askManualLottos();

        informBuyCount(
                lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE),
                manualLottos.size()
        );

        return new LottoPurchaseRequest(lottoPurchasePrice, manualLottos);
    }

    private Lottos buyLottos(LottoPurchaseRequest lottoPurchaseRequest) {
        Lottos lottos = LottoMachine.createTotallyLottos(
                lottoPurchaseRequest.calculateAutoLottoCount(PER_LOTTO_PRICE), lottoPurchaseRequest.manualLottos());

        informPublishedLottos(lottos.convertRawString());

        return lottos;
    }

    private WinningLottoNums getWinningLottoNums() {
        Set<LottoNum> lottoByNums = LottoMachine.createLottoNums(askLottoNums());
        LottoNum bonusNum = of(askBonusNum());

        return new WinningLottoNums(lottoByNums, bonusNum);
    }
}
