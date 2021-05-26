package lotto.domain;

import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManualLottoTicketGenerator implements TicketGenerator {
    @Override
    public List<LottoTicket> generate(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(extract());
        }
        return tickets;
    }

    private LottoTicket extract() {
        InputView inputView = new InputView();
        LottoTicket lottoTicket = null;

        while (lottoTicket == null) {
            lottoTicket = requestManualLottoTicket(inputView.receiveIntegerArrayInput());
        }
        return lottoTicket;
    }

    private LottoTicket requestManualLottoTicket(Integer[] inputs) {
        OutputView outputView = new OutputView();
        LottoTicket lottoTicket;
        try {
            lottoTicket = new LottoTicket(Arrays.asList(inputs));
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            lottoTicket = null;

        }
        return lottoTicket;
    }
}
