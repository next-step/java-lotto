package dev.solar.lotto;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final TreeSet<LottoNumber> lottoNumbers;
    private Integer prizeMoney;

    public static LottoTicket buyOne() {
        final TreeSet<LottoNumber> lottoNumbers = new TreeSet<>();
        while (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(LottoNumber.random());
        }
        return new LottoTicket(lottoNumbers);
    }

    public LottoTicket(final TreeSet<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoException("로또 한장 당 번호는 " + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
        }
    }

    public int checkWinningNumbers(final Set<LottoNumber> winningNumbers) {
        final int count = (int) winningNumbers.stream().filter(lottoNumbers::contains).count();
        decidePrizeMoney(count);
        return count;
    }

    private void decidePrizeMoney(final int count) {
        if (count == 3) {
            this.prizeMoney = 5000;
            return;
        }
        if (count == 4) {
            this.prizeMoney = 50000;
            return;
        }
        if (count == 5) {
            this.prizeMoney = 1500000;
            return;
        }
        if (count == 6) {
            this.prizeMoney = 2000000000;
            return;
        }
        this.prizeMoney = 0;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
               "lottoNumbers=" + lottoNumbers +
               '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
