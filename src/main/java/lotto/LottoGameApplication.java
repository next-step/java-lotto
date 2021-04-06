package lotto;

import lotto.domain.*;
import lotto.view.HitResultView;
import lotto.view.InputView;
import lotto.view.LottoGamesView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            inputView.inputPayMoney();
            List<Numbers> manualNumbers = inputView.inputManualGameNumbers(inputView.inputManualGameCount());

            Money payMoney = new Money(inputView.getPayMoney());
            LottoShop lottoShop = new LottoShop(payMoney, new DefaultNumberService(manualNumbers));

            Money autoMoney = payMoney.remainMoney(manualNumbers.size());
            LottoGamesView lottoGamesView = new LottoGamesView(lottoShop, manualNumbers.size(), autoMoney.lottoGameCount());
            lottoGamesView.printLottoGamesNumber();

            inputView.inputHitNumbers();
            inputView.inputHitBonusNumber();
            HitResults hitResults = lottoShop.match(inputView.winNumbers());

            HitResultView hitResultView = new HitResultView(hitResults, payMoney);
            hitResultView.printLottoResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
