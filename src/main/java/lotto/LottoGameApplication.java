package lotto;

import lotto.domain.HitResults;
import lotto.domain.LottoShop;
import lotto.domain.Money;
import lotto.domain.Numbers;
import lotto.view.HitResultView;
import lotto.view.InputView;
import lotto.view.LottoGamesView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPayMoney();

        Money payMoney = new Money(inputView.getPayMoney());
        LottoShop lottoShop = new LottoShop();
        List<Numbers> manualGame = new ArrayList<>();
        lottoShop.purchase(payMoney, manualGame);

        LottoGamesView lottoGamesView = new LottoGamesView(lottoShop);
        lottoGamesView.printLottoGamesNumber();

        inputView.inputHitNumbers();
        inputView.inputHitBonusNumber();
        HitResults hitResults = lottoShop.match(inputView.winNumbers());

        HitResultView hitResultView = new HitResultView(hitResults, payMoney);
        hitResultView.printLottoResult();
    }
}
