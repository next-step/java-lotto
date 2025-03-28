package step3.lotto.model;

import java.util.stream.LongStream;

public class LottoResult {

    private final Count match3LottoTicketCount = new Count(0);
    private final Count match4LottoTicketCount = new Count(0);
    private final Count match5LottoTicketCount = new Count(0);
    private final Count match6LottoTicketCount = new Count(0);

    public void reflect(Count count) {
        if (count.equals(new Count(3))) {
            match3LottoTicketCount.increase();
        }
        if (count.equals(new Count(4))) {
            match4LottoTicketCount.increase();
        }
        if (count.equals(new Count(5))) {
            match5LottoTicketCount.increase();
        }
        if (count.equals(new Count(6))) {
            match6LottoTicketCount.increase();
        }
    }

    public Count match3LottoTicketCount() {
        return match3LottoTicketCount;
    }

    public Count match4LottoTicketCount() {
        return match4LottoTicketCount;
    }

    public Count match5LottoTicketCount() {
        return match5LottoTicketCount;
    }

    public Count match6LottoTicketCount() {
        return match6LottoTicketCount;
    }

    public Money prizeMoney() {
        Money prizeMoney = new Money("0");
        LongStream.range(0, match3LottoTicketCount.value()).forEach(i -> prizeMoney.add(LottoPrize.moneyOf(new Count(3))));
        LongStream.range(0, match4LottoTicketCount.value()).forEach(i -> prizeMoney.add(LottoPrize.moneyOf(new Count(4))));
        LongStream.range(0, match5LottoTicketCount.value()).forEach(i -> prizeMoney.add(LottoPrize.moneyOf(new Count(5))));
        LongStream.range(0, match6LottoTicketCount.value()).forEach(i -> prizeMoney.add(LottoPrize.moneyOf(new Count(6))));
        return prizeMoney;
    }

}
