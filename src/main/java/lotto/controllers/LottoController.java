package lotto.controllers;

import lotto.domain.LottoDiscriminator;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.factories.LottoDiscriminatorFactory;
import lotto.utils.StringUtil;
import lotto.views.InputView;
import lotto.views.ResultView;

import java.util.List;

public class LottoController {
    public void run() {
        final int payment = InputView.payment();

        final List<LottoTicket> lottoTickets = new LottoStore().lottoTickets(payment);

        ResultView.print(lottoTickets);

        final String winnerNumbersInput = InputView.winnerNumbers();
        final String bonusNumberInput = InputView.bonusNumber();

        final LottoDiscriminator lottoDiscriminator = LottoDiscriminatorFactory.from(
                StringUtil.splitCommas(winnerNumbersInput), bonusNumberInput);
        final LottoStatistics lottoStatistics = new LottoStatistics(lottoDiscriminator, lottoTickets);

        ResultView.print(lottoStatistics, payment);
    }
}
