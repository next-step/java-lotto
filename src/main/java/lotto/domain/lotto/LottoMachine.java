package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.domain.winning.WinningLotto;

import java.util.List;
import java.util.Map;

public class LottoMachine {

    private final LottoTicket lottoTicket;

    public LottoMachine(Price price, List<String> manualNumberStrings) {
        this.lottoTicket = createLottoTicket(price, manualNumberStrings);
    }

    private LottoTicket createLottoTicket(Price price, List<String> manualNumberStrings) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(price, manualNumberStrings);
        return new LottoTicket(lottoNumberGenerator.getLottoNumbers());
    }

    public Map<LottoRank, Long> match(String winningNumbers, int bonusNumber) {
        return this.lottoTicket.matchWinningNumber(new WinningLotto(winningNumbers), new LottoNumber(bonusNumber));
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
