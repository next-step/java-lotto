package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class LottoTicket {
    static final Money TICKET_PRICE = Money.of(1000);

    private final LottoNumbers lottoNumbers;

    static LottoTicket of(int... lottoNumbers) {
        return new LottoTicket(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    static LottoTicket ofForm(LottoTicketForm lottoTicketForm) {
        return new LottoTicket(lottoTicketForm.getLottoNumbers());
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = LottoNumbers.of(lottoNumbers);
    }

    private LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    Rank checkWinning(WinningLotto winningLotto) {
        return Rank.of(winningLotto.match(lottoNumbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
