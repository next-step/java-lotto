package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class ManualLottoMain {

    public static void main(String[] args) {
        try {
            Money money = Money.of(InputView.getMoneyToBuyLotto());
            int numberOfTicket = LottoTickets.countTicketNumberByMoney(money);
            int numberOfManualLotto = InputView.getNumberOfManualLotto();

            LottoGenerator lottoGenerator = new LottoGenerator();
            // 티켓 수와 수동로또 티켓 수를 통해 수동티켓과 자동티켓을 생성함
            List<PlayersLotto> ManualAndAutoLottoTickets = lottoGenerator.purchaseManualAndAutoLottoTickets(numberOfTicket, numberOfManualLotto);
            LottoTickets purchasedLottoTickets = new LottoTickets(ManualAndAutoLottoTickets);

            // 구매한 각 종류 티켓의 장수 출력
            OutputView.printNumberOfEachTicket(numberOfTicket,numberOfManualLotto);
            // 무작위 로또의 값을 출력
            OutputView.printAllLotto(purchasedLottoTickets);
            // 지난주 로또 정답을 입력받음
            String winningLottoNumber = InputView.getLottoAnswer();
            // split 으로 정답 로또를 파싱해 리스트화
            List<LottoNumber> winningLotto = WinnerLotto.getLottoWithSplitting(winningLottoNumber);
            // 보너스 번호를 입력
            LottoNumber bonusNumber = new LottoNumber(InputView.getBonusBall());
            // 정답로또를 생성
            WinnerLotto winnerLotto = new WinnerLotto(bonusNumber, winningLotto);
            // 로또매처를 통해 플레이어의 로또와 정답의 비교 결과를 확인
            LottoMatcher lottoMatcher = new LottoMatcher();
            lottoMatcher.checkAllTickets(purchasedLottoTickets,winnerLotto);
            // 결과를 프린트
            OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
            // 수익을 계산
            Money revenue = ROICalculator.getRevenue(lottoMatcher.getPrizeBoard());
            OutputView.printReturnOnInvestment(ROICalculator.calculateReturnOnInvestment(revenue, money));


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
