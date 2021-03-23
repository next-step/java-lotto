package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoDiscriminator {
    public static final int WINNING_NUMBERS_SIZE = 6;

    private final List<LottoNumber> winningNumbers;

    public LottoDiscriminator(final List<LottoNumber> winningNumbers) {
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int matchingCount(final LottoTicket lottoTicket) {
        return lottoTicket.matchingCount(winningNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoDiscriminator that = (LottoDiscriminator) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
