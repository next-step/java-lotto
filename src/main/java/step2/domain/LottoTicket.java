package step2.domain;

import step2.dto.WinningNumber;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<WinningNumber> lottoTicket;

    public LottoTicket(Set<WinningNumber> lottoTicker) {
        this.lottoTicket = lottoTicker;
    }

    public long containsWinningNumber(Set<WinningNumber> winningNumbers) {
        return winningNumbers.stream()
                .filter(number -> lottoTicket.contains(number))
                .collect(Collectors.counting());
    }

    public Set<WinningNumber> lottoTicket() {
        return Collections.unmodifiableSet(lottoTicket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }
}
