package step2;

import step2.domain.LottoList;
import step2.view.Input;
import step2.view.Output;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer purchaseNumber = Input.inputPurchaseAmount();
        LottoList lottoList = new LottoList(purchaseNumber);
        Output.viewPurchasedLotto(lottoList);
        List<Integer> checkMatchingList = lottoList.checkMatching(Input.inputWinningNumbers());
        Output.viewResult(lottoList.getCountList(checkMatchingList));
    }
}
