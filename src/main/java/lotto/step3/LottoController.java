package lotto.step3;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.LottoNumber;
import lotto.step3.domain.LottoShop;
import lotto.step3.view.InputView;
import lotto.step3.view.ResultView;

import java.util.Set;

public class LottoController {
    public static void main(String[] args) {
        int money = InputView.inputLottoPrice();
        LottoShop lottoShop = new LottoShop();
        Lotteries lotteries = lottoShop.receiveMoney(money);
        ResultView.printLottoInfo(money, lotteries);
        Set<LottoNumber> winning = InputView.inputLastWinningNumbers();
    }
}
