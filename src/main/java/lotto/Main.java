package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGroup;
import lotto.pattern.LottoNumberGenerator;
import lotto.utils.StringLottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getMoney();

        LottoTicketGroup lottoTicketGroup = new LottoTicketGroup(money, new LottoNumberGenerator());

        ResultView.printLottoTicketsCount(lottoTicketGroup);
        ResultView.printLottoTickets(lottoTicketGroup);

        List<LottoNumber> winningLottoNumbers = StringLottoNumber.toList(InputView.getWinnerTicket());
        int bonusNumber = InputView.getBonusBall();

        Lotto lotto = new Lotto(new LottoTicket(winningLottoNumbers), new LottoNumber(bonusNumber));

        ResultView.printWinningStatistics(lotto.compareLotto(lottoTicketGroup, new LottoNumber(bonusNumber)), money);
    }
}
