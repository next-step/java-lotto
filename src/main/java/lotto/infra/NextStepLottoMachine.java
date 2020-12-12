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
        int manualTicketCount = manualNumbers.size();
        int autoTicketCount = ticketCount(amount) - manualTicketCount;
        return createLottoTickets(manualNumbers, autoTicketCount);
    }

    private int ticketCount(final long amount) {
        Money purchase = Money.valueOf(amount);
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

    @Override
    public LottoTickets automatic(final long amount) {
        Money purchase = Money.valueOf(amount);
        int count = purchase.divide(LottoTicket.PRICE);
        return createAutoTickets(count);
    }

    private LottoTickets createAutoTickets(final int count) {
        return IntStream.range(0, count)
                .mapToObj(ignore -> createAutoTicket())
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::of));
    }

    private LottoTicket createAutoTicket() {
        Collections.shuffle(CACHE);
        List<LottoNumber> shuffledNumber = new ArrayList<>(CACHE.subList(0, LottoTicket.LOTTO_NUMBER_COUNT));
        Collections.sort(shuffledNumber);
        return LottoTicket.of(shuffledNumber);
    }

    @Override
    public LottoTicket manual(final String numbers) {
        return createLottoTicket(numbers);
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
