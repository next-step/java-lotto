package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.util.LottoExchanger;

import java.util.List;

import static lotto.util.LottoResult.rankResult;
import static lotto.util.LottoResult.yieldResult;
import static lotto.view.InputView.inputMatchNumberList;
import static lotto.view.InputView.inputPurchasePrice;
import static lotto.view.ResultView.*;

public class main {

    public static void main(String[] args) {

        Lottos lottos = LottoExchanger.purchaseLottos(inputPurchasePrice());

        purchaseAmount(lottos);

        Lottos pickedLottos = lottos.pick();

        pickedLottos(pickedLottos);

        List<Integer> matchNumberList = inputMatchNumberList();

        Lottos rankedLottos = pickedLottos.rank(matchNumberList);

        List<Rank> rankList = rankResult(rankedLottos);

        rankedLottos(rankList);

        Integer yieldResult = yieldResult(rankedLottos);

        yieldLottos(yieldResult);

    }
}
