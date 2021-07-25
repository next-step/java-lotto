package lotto.lotto;

import lotto.dto.LottoTicketDto;
import lotto.number.WinningNumbers;
import lotto.prize.LottoPrize;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        validate(lottoTickets);

        this.lottoTickets = lottoTickets;
    }

    private void validate(List<LottoTicket> lottoTickets) {
        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("To init LottoTickets lottoTickets can't be null");
        }
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicketDto> getLottoTicketDtos() {
        return lottoTickets.stream()
                .map(LottoTicketDto::from)
                .collect(Collectors.toList());
    }

    public Map<LottoPrize, Long> matchWinningNumbers(WinningNumbers winningNumbers) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchPrize(winningNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int size() {
        return lottoTickets.size();
    }
}
