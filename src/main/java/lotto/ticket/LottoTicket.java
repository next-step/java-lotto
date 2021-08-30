package lotto.ticket;

import lotto.number.BonusNumber;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public LottoTicket(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers).mapToObj(LottoNumber::new).collect(Collectors.toList()));
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> lottoNumbers() {
        return this.lottoNumbers.value();
    }

    public Prize prize(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int winningNumberCounts = lottoNumbers.matchOf(winningNumbers);
        int bonusNumberCounts = lottoNumbers.matchOf(bonusNumber);
        return Prize.prize(winningNumberCounts, bonusNumberCounts);
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
}
