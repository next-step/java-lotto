package lotto.lotto;

import lotto.dto.LottoTicketDto;
import lotto.money.Money;
import lotto.number.WinningNumbers;
import lotto.prize.LottoPrize;
import lotto.prize.LottoPrizeTemp;
import lotto.prize.MatchResult;
import lotto.prize.MatchResult2;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lotto {
    private final Money payment;
    private final LottoTickets lottoTickets;

    private Lotto(Money payment, LottoTickets lottoTickets) {
        validate(payment, lottoTickets);

        this.payment = payment;
        this.lottoTickets = lottoTickets;
    }

    private void validate(Money payment, LottoTickets lottoTickets) {
        if (Objects.isNull(payment)) {
            throw new IllegalArgumentException("Money can't be null");
        }

        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("LottoTickets can't be null");
        }
    }

    public static Lotto of(Money payment, LottoTickets lottoTickets) {
        return new Lotto(payment, lottoTickets);
    }

    public MatchResult match(WinningNumbers winningNumbers) {
        Map<LottoPrize, Long> lottoPrizes = lottoTickets.matchWinningNumbers(winningNumbers);

        return MatchResult.of(payment, lottoPrizes);
    }

    public MatchResult2 match2(WinningNumbers winningNumbers) {
        Map<LottoPrizeTemp, Long> lottoPrizes = lottoTickets.matchWinningNumbers2(winningNumbers);

        return MatchResult2.of(payment, lottoPrizes);
    }

    public List<LottoTicketDto> getLottoTickets() {
        return lottoTickets.getLottoTicketDtos();
    }
}
