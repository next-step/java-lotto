package lotto.controllers;

import lotto.domain.*;
import lotto.factories.LottoDiscriminatorFactory;
import lotto.factories.LottoTicketFactory;
import lotto.utils.StringUtil;
import lotto.views.InputView;
import lotto.views.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    public void run() {
        final int payment = InputView.payment();
        final LottoBuyer lottoBuyer = new LottoBuyer(new LottoStore(), payment);

        final int manualLottoTicketsCount = InputView.manualLottoTicketsCount();
        lottoBuyer.validatePurchasable(manualLottoTicketsCount);

        final List<String> manualLottoTicketsInput = InputView.manualLottoTickets(manualLottoTicketsCount);
        final AllLottoTickets allLottoTickets = lottoBuyer.allLottoTickets(
                manualLottoTicketsInput.stream()
                        .map(StringUtil::splitCommas)
                        .map(LottoTicketFactory::from)
                        .collect(Collectors.toList())
        );

        ResultView.print(allLottoTickets);

        final String winnerNumbersInput = InputView.winnerNumbers();
        final String bonusNumberInput = InputView.bonusNumber();

        final LottoDiscriminator lottoDiscriminator = LottoDiscriminatorFactory.from(
                StringUtil.splitCommas(winnerNumbersInput), bonusNumberInput);
        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, allLottoTickets.allLottoTickets());

        ResultView.print(lottoStatistics, payment);
    }
}
