package lotto.domain.ticket;

import lotto.domain.AutoLottoNumberGenerator;
import lotto.domain.LottoNumber;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

public class LottoTicketGenerator {
    private final AutoLottoNumberGenerator autoLottoNumberGenerator = new AutoLottoNumberGenerator();

    public LottoTicket createAutoLottoTicket() {
        return new LottoTicket(autoLottoNumberGenerator.generate());
    }

    public LottoTicket createManualLottoTicket(final List<Integer> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(collectingAndThen(toSet(), LottoTicket::new));
    }
}
