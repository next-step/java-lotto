package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class LottoTicket {

    public static final int PRIZE_AMOUNT = 1_000;
    public static final int SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateLottoTicketSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(final int... lottoNumberArgs) {
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumberArgs)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        validateLottoTicketSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(final String... lottoNumberArgs) {
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoNumberArgs)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        validateLottoTicketSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoTicketSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("different number size");
        }
    }

    public LottoRank matchLottoRank(final WinningLottoTicket winningLottoTicket) {
        return LottoRank.of(matchCount(winningLottoTicket), winningLottoTicket.containsBonusNumber(this));
    }

    public int matchCount(final WinningLottoTicket winningLottoTicket) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount += countLottoNumberInWinningLottoTicket(winningLottoTicket, lottoNumber);
        }
        return matchCount;
    }

    private int countLottoNumberInWinningLottoTicket(WinningLottoTicket winningLottoTicket, LottoNumber lottoNumber) {
        return winningLottoTicket.contains(lottoNumber) ? 1 : 0;
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
