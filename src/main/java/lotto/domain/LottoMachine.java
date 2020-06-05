package lotto.domain;

import lotto.domain.dto.ManualNumberDto;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.vo.LottoMoney;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private LottoMachine() {
    }

    public static LottoBill purchaseLottoTicket(List<ManualNumberDto> manualNumberDtos, LottoMoney lottoMoney) {
        List<LottoTicket> lottoTickets = manualNumberDtos.stream()
                .map(ManualNumberDto::getManualNumbers)
                .map(LottoTicket::ofFixed)
                .collect(Collectors.toList());

        for (int i = 0; i < lottoMoney.getNumberOfAutoTicket(); i++) {
            lottoTickets.add(LottoTicket.ofAuto());
        }

        return new LottoBill(lottoTickets);
    }
}
