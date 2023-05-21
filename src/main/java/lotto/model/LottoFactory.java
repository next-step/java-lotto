package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static final int LOTTO_NUMBER_COUNT_LIMIT = 6;
    private static final List<LottoNumber> lottoNumbers = IntStream.range(LottoNumber.LOTTO_MINIMUM_NUMBER, LottoNumber.LOTTO_MAXIMUM_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    public static LottoTickets createAutoLottoTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> createAutoLottoTicket())
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    public static LottoTicket createAutoLottoTicket() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT_LIMIT)
                .collect(Collectors.toList()));
    }

    public static LottoTickets createLottoTickets(int autoTicketCount, List<LottoTicket> manualLottoTickets) {
        validateCount(autoTicketCount);
        List<LottoTicket> autoLottoTickets = IntStream.range(0, autoTicketCount)
                .mapToObj(i -> createAutoLottoTicket())
                .collect(Collectors.toList());

        manualLottoTickets.addAll(autoLottoTickets);
        return new LottoTickets(manualLottoTickets);
    }

    private static void validateCount(int autoTicketCount) {
        if (autoTicketCount < 0) {
            throw new IllegalArgumentException("구매 가능한 티켓 수를 초과했습니다.");
        }
    }

}
