package lotto.lotto;

import lotto.dto.LottoTicketDto;
import lotto.money.Money;
import lotto.money.PaymentInfo;
import lotto.number.WinningNumbers;
import lotto.prize.LottoPrize;
import lotto.prize.MatchResult;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Lotto {
    private final Money payment;
    private final PaymentInfo paymentInfo;
    private final LottoTickets lottoTickets;

    private Lotto(PaymentInfo paymentInfo, LottoTickets lottoTickets) {
        validate(paymentInfo, lottoTickets);

        this.paymentInfo = paymentInfo;
        this.payment = paymentInfo.payment();
        this.lottoTickets = lottoTickets;
    }

    private void validate(PaymentInfo paymentInfo, LottoTickets lottoTickets) {
        if (Objects.isNull(paymentInfo)) {
            throw new IllegalArgumentException("PaymentInfo can't be null");
        }

        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("LottoTickets can't be null");
        }
    }

    public static Lotto of(PaymentInfo paymentInfo, LottoTickets lottoTickets) {
        return new Lotto(paymentInfo, lottoTickets);
    }

    public MatchResult match(WinningNumbers winningNumbers) {
        Map<LottoPrize, Long> lottoPrizes = lottoTickets.matchWinningNumbers(winningNumbers);

        return MatchResult.of(payment, lottoPrizes);
    }

    public List<LottoTicketDto> getLottoTickets() {
        return lottoTickets.getLottoTicketDtos();
    }

    public PaymentInfo paymentInfo() {
        return paymentInfo;
    }
}
