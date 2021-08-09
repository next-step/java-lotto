package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {

        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        LottoShop lottoShop = new LottoShop(lottoGenerator);

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        long purchaseAmount = inputView.getInputAmount();

        LottoTickets lottoTickets = lottoShop.buy(purchaseAmount);

        ResultView.showBuyLottoTickets(lottoTickets);

        List<Integer> winningNumbers = inputView.getWinningNumber();
        int bonusNumber = inputView.getBonusNumber();
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningNumbers, bonusNumber);

        ResultView.showLottoResult(lottoStatistic, purchaseAmount);
    }
}
