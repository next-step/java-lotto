package lotto.controller.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.view.InputView;

public class ManualLottoTicketGenerator implements LottoTicketGenerator {
    public List<LottoTicket> createLottoTickets(int lottoTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        InputView inputView = new InputView();
        List<String> lottoTicketStrings = inputView.inputManualLottoTickets(lottoTicketCount);
        for (String lottoTicketString : lottoTicketStrings) {
            String[] lottoTicketStringArray = lottoTicketString.split(",");
            int[] lottoTicketIntArray = Arrays.stream(lottoTicketStringArray)
                .mapToInt(s -> Integer.parseInt(s.trim()))
                .toArray();
            lottoTickets.add(LottoTicket.of(lottoTicketIntArray));
        }
        return lottoTickets;
    }
}
