package lotto.dto;

import lotto.domain.ticket.LottoTickets;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class ManualLottoNumberRequestDto {
    private final List<ManualLottoNumbers> manualLottoNumberLines;

    public ManualLottoNumberRequestDto(List<ManualLottoNumbers> manualLottoNumberLines) {
        this.manualLottoNumberLines = manualLottoNumberLines;
    }

    public LottoTickets toLottoTickets() {
        return manualLottoNumberLines.stream()
                .map(ManualLottoNumbers::toLottoTicket)
                .collect(collectingAndThen(toList(), LottoTickets::new));
    }
}
