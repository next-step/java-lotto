package step2.domain.lotto;

import java.util.Arrays;
import java.util.List;

public class LottoTicket {

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public static LottoTicket from(LottoNumber lottoNumber) {
        return new LottoTicket(Arrays.asList(lottoNumber));
    }

    public int findMatchingCount(final LottoTicket winningLottoTicket) {
        return (int) winningLottoTicket.getLottoNumbers().get(0).getNumbers()
                .stream()
                .filter(number -> this.lottoNumbers.get(0).getNumbers().contains(number))
                .count();
    }
}
