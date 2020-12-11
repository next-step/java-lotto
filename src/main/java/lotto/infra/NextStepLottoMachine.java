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
        return LottoTicket.of(createManualLottoNumbers(numbers));
    }

    private List<LottoNumber> createManualLottoNumbers(final String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
