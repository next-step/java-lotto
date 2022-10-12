package step2.domain;

import step2.util.LottoNumberGenerator;
import step2.util.LottoUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int numOfTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            lottoTickets.add(new LottoTicket(
                    LottoUtil.generateLottoNumbers(lottoNumberGenerator.shuffleLottoNumbers())));
        }
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoNumbers() {
        return this.lottoTickets;
    }
}
