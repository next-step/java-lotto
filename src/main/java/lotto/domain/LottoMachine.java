package lotto.domain;

import lotto.domain.dto.ManualLottoDto;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.vo.LottoMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private LottoMachine() {
    }

    public static LottoBill purchaseLottoTicket(List<ManualLottoDto> manualLottoDtos, int numberOfAutoTicket) {
        List<LottoTicket> lottoTickets = manualLottoDtos.stream()
                .map(ManualLottoDto::getManualNumbers)
                .map(LottoTicket::ofFixed)
                .collect(Collectors.toList());

        for (int i = 0; i < numberOfAutoTicket; i++) {
            lottoTickets.add(LottoTicket.ofAuto());
        }

        return new LottoBill(lottoTickets);
    }
}
