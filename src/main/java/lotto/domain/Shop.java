package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    private static final int PRICE = 1000;

    public LottoTickets buy(int money, LottoMachine lottoMachine) {
        int count = money / PRICE;

        return new LottoTickets(
            IntStream.range(0, count).boxed()
                .map(n -> lottoMachine.publish())
                .collect(Collectors.toList()), PRICE);
    }

    public GameResult result(LottoTickets lottoTickets, ResultLotto resultLotto) {
        return lottoTickets.result(resultLotto);
    }
}
