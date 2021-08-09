package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class LottoTicket {

    private static final int LOTTO_TICKET_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateLottoTicketSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(final Integer[] lottoNumbers) {
        List<LottoNumber> collectLottoNumbers = Arrays.stream(lottoNumbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        validateLottoTicketSize(collectLottoNumbers);
        this.lottoNumbers = collectLottoNumbers;
    }

    private void validateLottoTicketSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("different number size");
        }
    }

    public int matchingTicket(final List<Integer> winningNumbers) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount = getMatchCount(winningNumbers, lottoNumber, matchCount);
        }
        return matchCount;
    }

    private int getMatchCount(final List<Integer> winningNumbers, final LottoNumber lottoNumber, final int matchCount) {
        if (winningNumbers.contains(lottoNumber.getNumber())) {
            return matchCount + 1;
        }
        return matchCount;
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
