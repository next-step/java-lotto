package step2;

import step2.domain.Lottos;

import step2.domain.starategy.RandomGetLottoImpl;
import step2.view.Input;
import step2.view.Output;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount, new RandomGetLottoImpl());
        Output.viewPurchasedLotto(lottos);
        List<Integer> matchingList = lottos.checkMatching(Input.inputWinningNumbers());
        Output.viewResult(matchingList,purchaseAmount);
    }
}
