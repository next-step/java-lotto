package lotto.domain;

import lotto.strategy.LottoNumberStrategy;
import lotto.strategy.LottoRandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static int PRICE_LOTTO_TICKET = 1000;
    private LottoWallet wallet;

    public Lotto(int price, List<String> pickNumbers) {
        int countTicket = price / PRICE_LOTTO_TICKET;
        int willGenerateCount = countTicket - pickNumbers.size();
        if (willGenerateCount < 0) {
            throw new IllegalArgumentException("구매하려는 로또 수가 더 클 수 없습니다.");
        }

        LottoTickets generated = generate(willGenerateCount, new LottoRandomStrategy());
        LottoTickets picked = pick(pickNumbers);

        this.wallet = new LottoWallet(generated, picked);
    }

    public LottoWallet generate() {
        return wallet;
    }

    public LottoResult start(String winnerNumbers, int bonusBall) {
        LottoTicket winner = LottoTicket.of(winnerNumbers);

        return wallet.checkWin(new LottoWinner(winner, bonusBall));
    }

    public LottoTickets generate(int numOfTickets, LottoNumberStrategy strategy) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            tickets.add(LottoTicket.of(strategy.generate()));
        }

        return new LottoTickets(tickets);
    }

    public LottoTickets pick(List<String> pickNumbers) {
        List<LottoTicket> list = pickNumbers.stream()
                .map(numbers -> LottoTicket.of(numbers))
                .collect(Collectors.toList());

        return new LottoTickets(list);
    }
}
