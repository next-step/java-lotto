package lotto.domain;

public class LottoTicket {

    public static final Money PRICE = Money.from(1_000);

    private final LottoNumbers numbers;

    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Rank rank(WinningLottoNumbers winnings) {
        return winnings.rank(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
