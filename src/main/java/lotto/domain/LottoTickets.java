package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoTickets {
    private final List<LottoNumbers> lottoTickets;
    private final TicketCount autoTicketCount;

    public LottoTickets(final List<LottoNumbers> lottoTickets, int autoTicketCount) {
        checkNullOrEmpty(lottoTickets);
        this.lottoTickets = lottoTickets;
        this.autoTicketCount = new TicketCount(autoTicketCount);
    }

    private void checkNullOrEmpty(final List<LottoNumbers> lottoTickets) {
        if (Objects.isNull(lottoTickets) || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("lottoTickets는 null이거나 empty 일 수 없습니다.");
        }
    }

    public Result check(final WinningNumbers winningNumbers) {
        Result result = new Result();
        lottoTickets.stream()
                .map(winningNumbers::checkWinning)
                .forEach(result::report);
        return result;
    }

    public List<LottoNumbers> getLottoTickets() {
        return lottoTickets;
    }

    public int getAutoTicketCount() {
        return autoTicketCount.getValue();
    }

    public int getManualTicketCount() {
        return lottoTickets.size() - getAutoTicketCount();
    }
}
