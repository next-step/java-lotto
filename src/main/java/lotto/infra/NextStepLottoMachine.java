package lotto.infra;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextStepLottoMachine implements LottoMachine {
    private static final String DELIMITER = ", ";

    private static final List<LottoNumber> CACHE = new ArrayList<>();

    static {
        IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                .forEach(value -> CACHE.add(LottoNumber.valueOf(value)));
    }

    @Override
    public LottoTickets generate(final long amount, final List<String> manualNumbers) {
        Money purchase = Money.valueOf(amount);
        int manualTicketCount = manualNumbers.size();
        validateAmount(purchase, manualTicketCount);
        int autoTicketCount = ticketCount(purchase) - manualTicketCount;
        return createLottoTickets(manualNumbers, autoTicketCount);
    }

    private void validateAmount(final Money purchase, final int manualTicketCount) {
        Money required = LottoTicket.PRICE.multiply(manualTicketCount);
        if (purchase.isLessThen(required)) {
            throw new IllegalArgumentException(
                    String.format("수동 로또 티켓 금액이 지불 금액보다 높습니다. (구매 금액: %s, 티켓 금액: %s", purchase, required));
        }
    }

    private int ticketCount(final Money purchase) {
        return purchase.divide(LottoTicket.PRICE);
    }

    private LottoTickets createLottoTickets(final List<String> manualNumbers, final int autoTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        addManualTickets(manualNumbers, lottoTickets);
        addAutoTickets(autoTicketCount, lottoTickets);
        return LottoTickets.of(lottoTickets);
    }

    private void addManualTickets(final List<String> manualNumbers, final List<LottoTicket> lottoTickets) {
        manualNumbers.forEach(manualNumber -> lottoTickets.add(createLottoTicket(manualNumber)));
    }

    private void addAutoTickets(final int autoTicketCount, final List<LottoTicket> lottoTickets) {
        IntStream.range(0, autoTicketCount)
                .forEach(ignore -> lottoTickets.add(createAutoTicket()));
    }

    private LottoTicket createAutoTicket() {
        Collections.shuffle(CACHE);
        List<LottoNumber> shuffledNumber = new ArrayList<>(CACHE.subList(0, LottoTicket.LOTTO_NUMBER_COUNT));
        Collections.sort(shuffledNumber);
        return LottoTicket.of(shuffledNumber);
    }

    @Override
    public WinningLotto winning(final String winningNumbers, final String bonusNumber) {
        LottoTicket winningTicket = createLottoTicket(winningNumbers);
        LottoNumber bonus = LottoNumber.valueOf(bonusNumber);
        return WinningLotto.of(winningTicket, bonus);
    }

    private LottoTicket createLottoTicket(final String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(LottoNumber::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::of));
    }
}
