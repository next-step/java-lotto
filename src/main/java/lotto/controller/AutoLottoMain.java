package lotto.controller;

import java.util.List;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AutoLottoMain {

    public static void main(String[] args) {
        try {
            int money = InputView.getMoneyToBuyLotto();
            int numberOfTicket = LottoTickets.countTicketNumberByMoney(money);

            LottoGenerator lottoGenerator = new LottoGenerator();
            // 무작위 로또를 생성해 로또티켓 객체에 생성자 주입
            List<PlayersLotto> generatedPlayersLottoNumbers = lottoGenerator.generateLottoTicketsAutomatically(numberOfTicket);
            LottoTickets purchasedTickets = LottoTickets.of(generatedPlayersLottoNumbers);
            // 무작위 로또의 값을 출력
            OutputView.printAllLotto(purchasedTickets);
            // 지난주 로또 정답을 입력받음
            String winningLottoNumber = InputView.getLottoAnswer();
            // 보너스 번호를 입력
            LottoNumber bonusNumber = LottoNumber.of(InputView.getBonusBall());
            // 정답로또를 생성. split 으로 정답 로또를 파싱해 리스트화
            WinnerLotto winnerLotto = WinnerLotto.of(bonusNumber, WinnerLotto.getLottoWithSplitting(winningLottoNumber));
            // 로또매처를 통해 플레이어의 로또와 정답의 비교 결과를 확인
            LottoMatcher lottoMatcher = new LottoMatcher();
            lottoMatcher.checkAllTickets(purchasedTickets,winnerLotto);
            // 결과를 프린트
            OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
            // 수익을 계산
            int revenue = ROICalculator.getRevenue(lottoMatcher.getPrizeBoard());
            OutputView.printReturnOnInvestment(ROICalculator.calculateReturnOnInvestment(revenue, money));
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
