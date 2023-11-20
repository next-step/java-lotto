package step3.domain.lotto;

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

    public int findCountOfMatch(LottoNumber lottoNumber) {
        return (int) this.lottoNumbers.get(0).getNumbers()
                .stream()
                .filter(number -> isContains(lottoNumber, number))
                .count();
    }

    private static boolean isContains(LottoNumber lottoNumber, Integer number) {
        return lottoNumber.getNumbers().contains(number);
    }
}
