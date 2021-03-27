package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private final LottoTicketPrice lottoTicketPrice;
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.lottoTicketPrice = new LottoTicketPrice();
    }

    public List<Integer> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers.lottoNumbers());
    }

    public int price() {
        return lottoTicketPrice.price();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicketPrice, that.lottoTicketPrice) &&
                Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicketPrice, lottoNumbers);
    }
}
