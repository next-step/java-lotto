package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.LottoMachine;
import lotto.controller.ResultGroupDto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.ResultGroup;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    private static final String WINNING_LOTTO_DELIMITER = ", ";

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
        List<LottoNumber> lottoNumbers = Arrays.stream(winningLottoLine.split(WINNING_LOTTO_DELIMITER))
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        String bonusBall = InputView.getBonusBall();
        int parseBonus = Integer.parseInt(bonusBall);
        lottoNumbers.add(new LottoNumber(parseBonus));
        return new WinningLotto(lottoNumbers);
    }

    private static LottoCount initializeCount(Money money) {
        return new LottoCount(money.value());
    }

    private static Money getMoneyFromUser() {
        String inputMoney = InputView.getMoneyToPurchase();
        return new Money(inputMoney);
    }
}
