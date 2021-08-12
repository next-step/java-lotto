package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class LottoTicket {

    public static final int LOTTO_TICKET_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateLottoTicketSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(final int[] lottoNumberArr) {
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumberArr)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        validateLottoTicketSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoTicketSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("different number size");
        }
    }

    public LottoRank matchLottoRank(final WinningLottoTicket winningLottoTicket) {
        int matchCount = matchCount(winningLottoTicket);
        boolean contains = contains(winningLottoTicket.getBonusNumber());
        return LottoRank.of(matchCount, contains);
    }

    public int matchCount(final WinningLottoTicket winningLottoTicket) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount += winningLottoTicket.contains(lottoNumber);
        }
        return matchCount;
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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
