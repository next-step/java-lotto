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
        LottoTicketGroup autoLottoTicketGroup = new LottoTicketGroup(pay, new LottoNumberGenerator());

        List<String> manualLottoList = InputView.getManualLottoNumbers(manualTicketCount);

        LottoTicketGroup lottoTicketGroup =
                new LottoTicketGroup(
                        manualLottoList
                                .stream()
                                .map(lottoNumbers -> new LottoTicket(StringLottoNumber.toList(lottoNumbers)))
                                .collect(Collectors.toList())
                ).merge(autoLottoTicketGroup);

        ResultView.printLottoTickets(lottoTicketGroup);

        List<LottoNumber> winningLottoNumbers = StringLottoNumber.toList(InputView.getWinnerTicket());

        RankGroup rankGroup = lottoTicketGroup.getLottoRankings(new WinningLotto(new LottoTicket(winningLottoNumbers), new LottoNumber(InputView.getBonusBall())));

        ResultView.printWinningStatistics(rankGroup, pay);
    }
}
