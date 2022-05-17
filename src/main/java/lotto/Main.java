package lotto;

import lotto.domain.*;
import lotto.pattern.LottoNumberGenerator;
import lotto.utils.StringLottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int money = InputView.getMoney();
        int manualTicketCount = InputView.getManualTicketCount();

        Pay pay = new Pay(money, manualTicketCount);
        LottoTickets autoLottoTickets = new LottoTickets(pay, new LottoNumberGenerator());

        List<String> manualLottoList = InputView.getManualLottoNumbers(manualTicketCount);

        LottoTickets lottoTickets =
                new LottoTickets(
                        manualLottoList
                                .stream()
                                .map(lottoNumbers -> new LottoTicket(StringLottoNumber.toList(lottoNumbers)))
                                .collect(Collectors.toList())
                ).merge(autoLottoTickets);

        ResultView.printLottoTickets(lottoTickets);

        List<LottoNumber> winningLottoNumbers = StringLottoNumber.toList(InputView.getWinnerTicket());

        Ranks ranks = lottoTickets.getLottoRankings(new WinningLotto(new LottoTicket(winningLottoNumbers), new LottoNumber(InputView.getBonusBall())));

        ResultView.printWinningStatistics(ranks, pay);
    }
}
