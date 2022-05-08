package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoRule.NUMBERS_IN_GAME;

public class LottoVendingMachine {
    public static final long PRICE = 1_000;
    private static final LottoNumbers ALL_NUMBERS = LottoNumbers.all();

    private final LottoNumbers lottoNumbers;
    private Amount balance;

    public LottoVendingMachine() {
        this(ALL_NUMBERS, new Amount());
    }

    public LottoVendingMachine(LottoNumbers lottoNumbers, Amount balance) {
        validate(lottoNumbers, balance);
        this.lottoNumbers = lottoNumbers;
        this.balance = balance;
    }

    private void validate(LottoNumbers lottoNumbers, Amount balance) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("LottoVendingMachine은 lottoNumbers없이 생성할 수 없습니다.");
        }

        if (balance == null) {
            throw new IllegalArgumentException("LottoVendingMachine은 balance없이 생성할 수 없습니다.");

        }
    }

    public void insert(Amount amount) {
        balance = balance.save(amount);
    }

    private long buyableCount() {
        return balance.getAmount() / PRICE;
    }

    private Amount calculatePrice(int count) {
        return new Amount(count * PRICE);
    }

    public LottoTickets vend() {
        List<LottoTicket> lottoTickets = IntStream.range(0, (int) (buyableCount()))
                .mapToObj(i -> new LottoTicket(lottoNumbers.getRandomNumbers(NUMBERS_IN_GAME), LottoTicketType.AUTO))
                .collect(Collectors.toList());

        spend(lottoTickets.size());
        return new LottoTickets(lottoTickets);
    }

    public LottoTickets vend(List<LottoNumbers> lottoNumbersList) {
        if (lottoNumbersList.size() > buyableCount()) {
            throw new IllegalArgumentException(
                    String.format("LottoTicket(size = %s)은 잔액(%s) 초과로 구매할 수 없습니다.", lottoNumbersList.size(), balance.getAmount())
            );
        }

        LottoTickets lottoTickets = new LottoTickets(
                lottoNumbersList.stream()
                        .map(numbers -> new LottoTicket(numbers, LottoTicketType.MANUAL))
                        .collect(Collectors.toList()));

        spend(lottoTickets.size());
        return lottoTickets;
    }

    private void spend(int ticketSize) {
        balance = balance.spend(calculatePrice(ticketSize));
    }

    public Amount getBalance() {
        return balance;
    }
}
