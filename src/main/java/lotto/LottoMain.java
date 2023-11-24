package lotto;


import lotto.domain.LottoNumbers;
import lotto.domain.Tickets;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();

        Tickets tickets = new Tickets();
        tickets.sellTickets(lottoInputView.inputAmount("구매금액을 입력해주세요."));
        LottoResultView.printTicket(tickets);

        LottoNumbers winningNumber = new LottoNumbers(lottoInputView.inputStringLine("당첨번호를 입력해주세요."));

        LottoResult lottoResult = new LottoResult(tickets.makeStatistics(winningNumber), tickets.calcRateOfReturn(winningNumber));

        LottoResultView.printResult(lottoResult);
    }
}
