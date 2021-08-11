package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    public static void main(String[] args) {
        // 구매 금액 입력
        InputView inputView = new InputView();
        int moneyInteger = inputView.inputMoney();
        Money money = new Money(moneyInteger);

        // 수동 구매 개수 입력
        int manualCount = inputView.inputManualCount();
        if (money.countLotto() < manualCount) {
            throw new IllegalArgumentException("로또 구입 금액이 부족합니다.");
        }

        // 수동 구매 번호 입력
        List<List<Integer>> manualLottoTicketsInteger = inputView.inputManualLottoTickets(manualCount);
        List<LottoTicket> manualLottoTickets = manualLottoTicketsInteger.stream().map(LottoTicket::new).collect(Collectors.toList());

        // 랜덤 로또 티켓 생성
        List<LottoTicket> randomLottoTickets = new ArrayList<>();
        RandomLottoNumbers randomLottoNumbers = new RandomLottoNumbers();
        for(int i=0; i< money.countLotto() - manualCount; i++){
            randomLottoTickets.add(randomLottoNumbers.generateNumbers());
        }
        LottoTickets lottoTickets = new LottoTickets(randomLottoTickets, manualLottoTickets);

        // 구매 티켓 출력
        OutputView outputView = new OutputView();
        outputView.printPurchase(lottoTickets, manualCount);

        // 당첨번호 입력
        List<Integer> winNumbers = inputView.inputWinNumbers();

        // 2등 보너스볼 입력
        int bonusNumber = inputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);

        // 당첨 통계
        outputView.printWinStats(lottoTickets.getWinStats(winLotto, money));
    }
}
