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
        LottoPaper lottoPaper = getLottoPaper(numberOfAllLottoTicket, numberOfManualLottoTicket);

        lottos = lottoMachine.purchaseLottos(lottoPaper);
        OutputView.printPurchaseNumber(lottos.size()); // 개를 구입했습니다.

        OutputView.printGeneratedLottos(numberOfManualLottoTicket, numberOfAllLottoTicket-numberOfManualLottoTicket, lottos); // 생성된 로또 목록
    }

    private LottoPaper getLottoPaper(int numberOfAllLottoTicket, int numberOfManualLottoTicket) {
        try {
            List<String> manualLottoNumbers = InputView.getManualLottoNumbers(numberOfManualLottoTicket);
            return new LottoPaper(manualLottoNumbers, numberOfAllLottoTicket, numberOfManualLottoTicket);
        } catch (IllegalArgumentException iae) {
            System.out.println("올바른 숫자를 입력해주세요.");
            return getLottoPaper(numberOfAllLottoTicket, numberOfManualLottoTicket);
        }
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

    public void enterWinningNumber() {
        List<LottoNumber> winningLottoNumbers = InputView.getWinningNumbers(); // 당첨 번호를 입력해주세요
        int bonusBall = InputView.getBonusBall();  // 보너스 볼을 입력해 주세요.
        winningLotto = WinningLotto.generate(new Lotto(winningLottoNumbers), new LottoNumber(bonusBall));
    }

    public void getLottoResult() {
        Map<WinningType, Integer> matchResult = lottoMachine.calculateResult(winningLotto, lottos); // 로또 결과 계산
        float profitRate = LottoMachine.getProfitRate(matchResult, money);
        OutputView.printResult(matchResult, money.getValue(), profitRate); // 로또 결과 출력
    }
}
