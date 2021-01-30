package lotto;

import java.util.List;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        try {
            int money = InputView.getMoneyToBuyLotto();
            int numberOfTicket = LottoTickets.countTicketNumberByMoney(money);

            LottoGenerator lottoGenerator = new LottoGenerator();
            // 무작위 로또를 생성해 로또티켓 객체에 생성자 주입
            List<PlayersLotto> generatedPlayersLottoNumbers = lottoGenerator.generateLottoTickets(numberOfTicket);
            LottoTickets purchasedTickets = new LottoTickets(generatedPlayersLottoNumbers);
            // 무작위 로또의 값을 출력
            OutputView.printAllLotto(purchasedTickets);
            // 지난주 로또 정답을 입력받음
            String winningLottoNumber = InputView.getLottoAnswer();
            // split 으로 정답 로또를 파싱해 리스트화
            List<LottoNumber> winningLotto = WinnerLotto.getWinnerLottoWithSplitting(winningLottoNumber);
            // 보너스 번호를 입력
            LottoNumber bonusNumber = new LottoNumber(InputView.getBonusBall());
            // 정답로또를 생성
            WinnerLotto winnerLotto = new WinnerLotto(bonusNumber, winningLotto);
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
