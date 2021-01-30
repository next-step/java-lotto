package lotto.domain;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        try {
            int money = InputView.getMoneyToBuyLotto();
            int numberOfTicket = LottoTickets.countTicketNumberByMoney(money);
            int matchCnt = 0;
            LottoGenerator lottoGenerator = new LottoGenerator();
            // 무작위 로또를 생성해 로또티켓 객체에 생성자 주입
            List<PlayersLotto> generatedPlayersLottoNumbers = lottoGenerator.generateLottoTickets(numberOfTicket);
            LottoTickets purchasedTickets = new LottoTickets(generatedPlayersLottoNumbers);
            // 무작위 로또의 값을 출력
            OutputView.printAllLotto(purchasedTickets);
            // 지난주 로또 정답을 입력받음
            String winningLottoNumber = InputView.getLottoAnswer();
            List<LottoNumber> winningLotto = WinnerLotto.getWinnerLottoWithSplitting(winningLottoNumber);
            LottoNumber bonusNumber = new LottoNumber(InputView.getBonusBall());
            WinnerLotto winnerLotto = new WinnerLotto(bonusNumber, winningLotto);

            LottoMatcher lottoMatcher = new LottoMatcher();
            lottoMatcher.checkAllTickets(purchasedTickets,winnerLotto);

            OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
            int revenue = ROICalculator.getRevenue(lottoMatcher.getPrizeBoard());
            OutputView.printReturnOnInvestment(ROICalculator.calculateReturnOnInvestment(revenue, money));
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
