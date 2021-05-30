package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.WinningNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.LottoResult;
import lotto.shop.Money;
import lotto.shop.Shop;
import lotto.ui.OutputView;
import lotto.ui.InputView;

public class LottoGame {
    public static void start() {
        Shop shop = new Shop();
        Money money = inputMoney();
        int selfLottoQuantity = inputSelfLottoQuantity();
        Money balance = shop.buySelfLotto(money, selfLottoQuantity);
        OutputView.printInputSelfLottoNumber();
        LottoTicket lottoTicket = inputSelfLottoNumber(selfLottoQuantity);
        lottoTicket = shop.buyAutoLotto(lottoTicket, balance);
        printLotto(lottoTicket, selfLottoQuantity);

        WinningNumber winningNumber = new WinningNumber(InputView.inputLottoNumber());
        LottoNumber bonusNumber = inputBonusNumber();
        shop.checkDuplicateBonusNumber(winningNumber, bonusNumber);
        LottoResult lottoResult = shop.lottoResult(lottoTicket, winningNumber, bonusNumber);

        OutputView.resultMessage(lottoResult, money);
    }

    private static Money inputMoney() {
        OutputView.printInputMoneyMessage();
        return InputView.inputMoneyAmount();
    }

    private static int inputSelfLottoQuantity() {
        OutputView.printInputSelfLottoQuantity();
        return InputView.inputNumber();
    }

    private static LottoNumber inputBonusNumber() {
        OutputView.printBonusNumber();
        return LottoNumber.of(InputView.inputNumber());
    }

    private static LottoTicket inputSelfLottoNumber(int selfAmount) {
        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0; i < selfAmount; i++) {
            lottoTicket.add(new Lotto(InputView.inputLottoNumber()));
        }
        return lottoTicket;
    }

    private static void printLotto(LottoTicket lottoTicket, int selfQuantity) {
        OutputView.printLottoQuantity(selfQuantity, lottoTicket.matchingCount() - selfQuantity);
        OutputView.printLottoTicket(lottoTicket);
        OutputView.printWinningNumber();
    }
}