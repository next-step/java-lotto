package lotto.domain;

import lotto.domain.generator.LottoNumbersGenerator;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoTicket {
    private LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbersGenerator generator) {
        this.lottoNumbers = new LottoNumbers(generator);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public void match(WinningNumbers winningNumbers) {
        LottoRank match = lottoNumbers.match(winningNumbers);

        System.out.println("");
    }
}
