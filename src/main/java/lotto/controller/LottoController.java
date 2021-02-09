package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    LottoMachine lottoMachine = new LottoMachine();
    List<Lotto> lottos;
    WinningLotto winningLotto;
    Money money;

    public void buyLotto() {
        money = new Money(InputView.getLottoMoney()); // 구입금액을 입력해주세요
        int numberOfAllLottoTicket = lottoMachine.getLottoTicketNumber(money);
        int numberOfManualLottoTicket = getNumberOfManualLottoTicket(numberOfAllLottoTicket); // 수동으로 구매할 로또 수
        List<List<Integer>> manualLottoNumbers = InputView.getManualLottoNumbers(numberOfManualLottoTicket);

        int numberOfAutoLottoTicket = getNumberOfAutoLottoTicket(numberOfManualLottoTicket);
        lottos = lottoMachine.purchaseLottos(numberOfAllLottoTicket, numberOfManualLottoTicket, manualLottoNumbers);
        OutputView.printPurchaseNumber(lottos.size()); // 개를 구입했습니다.

        OutputView.printGeneratedLottos(numberOfManualLottoTicket, numberOfAutoLottoTicket, lottos); // 생성된 로또 목록
    }

    private int getNumberOfManualLottoTicket(int numberOfAllLottoTicket) {
        int numberOfManualLottoTicket = InputView.getNumberOfManualLottoTicket(); // 수동으로 구매할 로또 수
        try {
            lottoMachine.isValidNumberOfManualLottoTicket(numberOfAllLottoTicket, numberOfManualLottoTicket);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.isNotValidNumberOfManualLottoTicket();
            numberOfManualLottoTicket = getNumberOfManualLottoTicket(numberOfAllLottoTicket);
        }
        return numberOfManualLottoTicket;
    }

    private int getNumberOfAutoLottoTicket(int numberOfManualLottoTicket) {
        int numberOfAllLottoTicket = lottoMachine.getLottoTicketNumber(money);
        return lottoMachine.getAutoLottoTicketNumber(numberOfAllLottoTicket,
                numberOfManualLottoTicket);
    }

    public void enterWinningNumber() {
        List<Integer> winningLottoNumbers = InputView.getWinningNumbers(); // 당첨 번호를 입력해주세요
        int bonusBall = InputView.getBonusBall();  // 보너스 볼을 입력해 주세요.
        winningLotto = WinningLotto.generate(new Lotto(winningLottoNumbers), bonusBall);
    }

    public void getLottoResult() {
        Map<WinningType, Integer> matchResult = lottoMachine.calculateResult(winningLotto, lottos); // 로또 결과 계산
        float profitRate = LottoMachine.getProfitRate(matchResult, money);
        OutputView.printResult(matchResult, money.getValue(), profitRate); // 로또 결과 출력
    }
}
