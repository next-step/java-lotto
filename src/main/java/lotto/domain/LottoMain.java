package lotto.domain;

import java.util.Arrays;
import java.util.List;

import lotto.view.InputView;

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

            // 지난주 로또 정답을 입력받음
            String winningLottoNumber = InputView.getLottoAnswer();
            List<LottoNumber> winningLotto = WinnerLotto.getWinnerLottoWithSplitting(winningLottoNumber);
            LottoNumber bonusNumber = new LottoNumber(InputView.getBonusBall());
            WinnerLotto winnerLotto = new WinnerLotto(bonusNumber, winningLotto);

            for (int i = 0; i < purchasedTickets.getNumberOfTickets(); i++) {
                matchCnt = LottoMatcher.getMatchCnt(purchasedTickets.getLottoTickets().get(i).getNumbers(), winnerLotto);
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
