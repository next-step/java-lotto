package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Ticket {

    private final List<LottoNumber> lottoNumbers;

    public Ticket(List<LottoNumber> ticket) {
        lottoNumbers = ticket;
    }

    public long matchWinningNumber(WinningNumber winningNumber) {
        return winningNumber.getWinningNumber()
            .lottoNumbers.stream()
            .filter(lottoNumbers::contains)
            .count();
    }

    public boolean matchBonus(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    public int getLottoSize() {
        return lottoNumbers.size();
    }

    public boolean isNumberUnique() {
        return lottoNumbers
            .stream()
            .distinct()
            .count() == lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return Objects.equals(lottoNumbers, ticket.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
