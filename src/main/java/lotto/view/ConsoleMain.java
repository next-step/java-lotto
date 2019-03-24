package lotto.view;

import lotto.domain.*;
import lotto.tool.LottoMachine;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        //구입금액 입력
        LottoMoney lottoMoney = InputView.inputMoney();
        //구매장수 출력
        OutputView.printTicketCount(lottoMoney);

        //로또 생성
        List<LottoTicket> lottoTickets = LottoMachine.issueTickets(lottoMoney.buy());
        OutputView.printTickets(lottoTickets);

        //당첨금액, 보너스번호 입력
        WinningLotto winningLotto = InputView.inputWinningNumbers();

        //당첨통계
        LottoMatcher lottoMatcher = new LottoMatcher(lottoTickets, winningLotto);
        OutputView.printRankResult(lottoMatcher);
        //총수익률 표시
        EarningRate earningRate = new EarningRate(lottoMatcher, lottoMoney);
        OutputView.printEarningRate(earningRate);
    }
}
