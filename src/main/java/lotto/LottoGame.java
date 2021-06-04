package lotto;

import java.util.List;

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
        LottoTicket lottoTicket = inputSelfLottoNumber(selfLottoQuantity, shop.buyAutoLotto(balance));
        printLotto(lottoTicket, selfLottoQuantity);

        WinningNumber winningNumber = new WinningNumber(InputView.inputLottoNumbers());
        LottoNumber bonusNumber = inputBonusNumber();
        LottoResult lottoResult = lottoTicket.matchWinningNumber(winningNumber, bonusNumber);

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

    private static LottoTicket inputSelfLottoNumber(int selfLottoQuantity, int autoLottoQuantity) {
        List<Lotto> lottos = InputView.inputLottos(selfLottoQuantity);
        return new LottoTicket(lottos, autoLottoQuantity);
    }

    private static void printLotto(LottoTicket lottoTicket, int selfQuantity) {
        OutputView.printLottoQuantity(selfQuantity, lottoTicket.quantity() - selfQuantity);
        OutputView.printLottoTicket(lottoTicket);
        OutputView.printWinningNumber();
    }
}