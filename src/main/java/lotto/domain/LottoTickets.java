package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoTickets {
    private final List<LottoNumbers> lottoTickets;

    public LottoTickets(final List<LottoNumbers> lottoTickets) {
        checkNullOrEmpty(lottoTickets);
        this.lottoTickets = lottoTickets;
    }

    private void checkNullOrEmpty(final List<LottoNumbers> lottoTickets) {
        if (Objects.isNull(lottoTickets) || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("lottoTickets는 null이거나 empty 일 수 없습니다.");
        }
    }

    public Result check(final LottoNumbers winningNumbers) {
        Result result = new Result();
        lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.check(winningNumbers))
                .forEach(result::report);
        return result;
    }

    public List<LottoNumbers> getLottoTickets() {
        return lottoTickets;
    }
}
