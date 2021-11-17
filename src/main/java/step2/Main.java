package step2;

import step2.domain.LottoList;

import step2.domain.starategy.RandomGetLottoImpl;
import step2.view.Input;
import step2.view.Output;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.inputPurchaseAmount();

        LottoList lottoList = new LottoList(input.getPurchaseAmount(), new RandomGetLottoImpl());
        Output.viewPurchasedLotto(lottoList);
        List<Integer> matchingList = lottoList.checkMatching(input.inputWinningNumbers());
        Output.viewResult(matchingList,input.getPurchaseAmount());
    }
}
