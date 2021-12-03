package lotto.domain;

import static utils.IntegerValidator.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    public LottoTickets buy(int money, LottoMachine lottoMachine) {
        int count = getNumberIfPositive(money) / LottoTicket.PRICE;

        return new LottoTickets(
            IntStream.range(0, count).boxed()
                .map(n -> lottoMachine.publish())
                .collect(Collectors.toList()));
    }

    public GameResult result(LottoTickets lottoTickets, ResultLotto resultLotto) {
        return lottoTickets.result(resultLotto);
    }
}
