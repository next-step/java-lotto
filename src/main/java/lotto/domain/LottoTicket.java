package lotto.domain;

import java.util.Objects;

public final class LottoTicket {

    private final Money fee;
    private final LottoNumbers lottoNumbers;

    public LottoTicket(final Money fee, final LottoNumbers lottoNumbers) {
        this.fee = fee;
        this.lottoNumbers = lottoNumbers;
    }

    public Money getFee() {
        return fee;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoTicket that = (LottoTicket) o;
        return fee.equals(that.fee) && lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fee, lottoNumbers);
    }

}
