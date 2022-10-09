package lottogame.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class LottoTicket {
    private final String ticketId;
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.ticketId = UUID.randomUUID().toString();
        this.lottoNumbers = lottoNumbers;
    }

    public int countSameNumbers(LottoResult lottoResult) {
        return lottoNumbers.countSameNumbers(lottoResult.getLottoNumbers());
    }

    public boolean hasBonusNumber(LottoResult lottoResult) {
        return lottoNumbers.hasNumber(lottoResult.getBonusNumber());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoTicket that = (LottoTicket)o;
        return Objects.equals(ticketId, that.ticketId) && Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, lottoNumbers);
    }
}
