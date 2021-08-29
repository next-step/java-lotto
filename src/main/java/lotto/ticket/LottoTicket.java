package lotto.ticket;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;

import java.util.List;
import java.util.Objects;

public class LottoTicket {

    public final static int PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> value() {
        return this.lottoNumbers.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public Prize getPrize(WinningNumbers winningNumbers) {
        int winningNumberCounts = lottoNumbers.matchOfWinningNumbers(winningNumbers);
        return Prize.calculatePrizeMoney(winningNumberCounts);
    }
}
