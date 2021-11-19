package lotto;

import lotto.domain.Lottos;

import lotto.domain.starategy.RandomGetLottoImpl;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount, new RandomGetLottoImpl());
        Output.viewPurchasedLotto(lottos);
        List<Integer> matchingList = lottos.checkMatching(Input.inputWinningNumbers());
        Output.viewResult(matchingList, purchaseAmount);
    }
}
