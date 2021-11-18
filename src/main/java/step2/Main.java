package step2;

import step2.domain.LottoList;

import step2.domain.starategy.RandomGetLottoImpl;
import step2.view.Input;
import step2.view.Output;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer purchaseAmount = Input.inputPurchaseAmount();
        LottoList lottoList = new LottoList(purchaseAmount, new RandomGetLottoImpl());
        Output.viewPurchasedLotto(lottoList);
        List<Integer> matchingList = lottoList.checkMatching(Input.inputWinningNumbers());
        Output.viewResult(matchingList,purchaseAmount);
    }
}
