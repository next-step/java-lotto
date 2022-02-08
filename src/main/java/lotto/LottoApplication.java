package lotto;

import lotto.controller.LottoMachine;
import lotto.controller.ResultGroupDto;
import lotto.domain.LottoCount;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.ResultGroup;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {


    public static void main(String[] args) {
        Money money = getMoneyFromUser();
        LottoCount lottoCount = initializeCount(money);
        OutputView.printLottoCount(lottoCount.count());
        LottoTicket lottoTicket = LottoMachine.purchaseLotto(lottoCount);
        OutputView.printLotto(lottoTicket.values());
        WinningLotto winningLotto = getWinningLotto();
        ResultGroup resultGroup = LottoMachine.getResult(lottoTicket, winningLotto);
        ResultGroupDto resultGroupDto = new ResultGroupDto(resultGroup, money);
        OutputView.printResult(resultGroupDto);
    }

    private static WinningLotto getWinningLotto() {
        String winningLottoLine = InputView.getWinningLotto();
        return LottoMachine.generateWinningLotto(winningLottoLine);
    }

    private static LottoCount initializeCount(Money money) {
        return LottoCount.from(money);
    }

    private static Money getMoneyFromUser() {
        String inputMoney = InputView.getMoneyToPurchase();
        return new Money(inputMoney);
    }
}
