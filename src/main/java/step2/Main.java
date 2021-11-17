package step2;

import step2.domain.LottoList;
import step2.domain.Prize;
import step2.view.Input;
import step2.view.Output;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.inputPurchaseAmount();

        LottoList lottoList = new LottoList(input.getPurchaseAmount());
        Output.viewPurchasedLotto(lottoList);
        List<Integer> matchingList = lottoList.checkMatching(input.inputWinningNumbers());
        List<Integer> countList = lottoList.getCountList(matchingList);
        Output.viewResult(countList,input.getPurchaseAmount());
    }
}
