package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        long purchaseAmount = inputView.getInputAmount();
        long manualLottoCount = inputView.getManualLottoCount();
        String[] manualLottoNumbers = inputView.getManualLottoNumbers(manualLottoCount);

        AutoLottoGenerator lottoGenerator = new AutoLottoGenerator();
        LottoShop lottoShop = new LottoShop(lottoGenerator);

        LottoTickets lottoTickets = lottoShop.buy(purchaseAmount, manualLottoNumbers);
        ResultView.showBuyLottoTickets(lottoTickets, (int)manualLottoCount);

        List<Integer> winningNumbers = inputView.getWinningNumber();
        int bonusNumber = inputView.getBonusNumber();
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, bonusNumber);

        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningLottoTicket);
        ResultView.showLottoResult(lottoStatistic, purchaseAmount);
    }
}
