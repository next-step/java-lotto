package lotto.ticket;

import lotto.number.BonusNumber;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int PRICE = 1000;
    private final LottoNumbers lottoNumbers;
    private final TicketType ticketType;

    public LottoTicket(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this(lottoNumbers, TicketType.AUTO);
    }

    public LottoTicket(List<LottoNumber> lottoNumbers, TicketType ticketType) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
        this.ticketType = ticketType;
    }

    public static LottoTicket valueOf(List<Integer> lottoNumbers) {
        return new LottoTicket(
                lottoNumbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    public static LottoTicket ticketWithType(List<Integer> lottoNumbers, TicketType ticketType) {
        List<LottoNumber> converted = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoTicket(converted, ticketType);
    }

    public List<LottoNumber> lottoNumbers() {
        return this.lottoNumbers.value();
    }

    public Prize prize(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int winningNumberCounts = lottoNumbers.matchOf(winningNumbers);
        int bonusNumberCounts = lottoNumbers.matchOf(bonusNumber);
        return Prize.prize(winningNumberCounts, bonusNumberCounts);
    }

    public boolean isAuto() {
        return ticketType.equals(TicketType.AUTO);
    }

    public boolean isManual() {
        return ticketType.equals(TicketType.MANUAL);
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
}
