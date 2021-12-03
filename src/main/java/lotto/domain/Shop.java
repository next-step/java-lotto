package lotto.domain;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shop {

    public LottoTickets buy(Wallet wallet, LottoMachine lottoMachine) {

        return new LottoTickets(
            IntStream.range(0, wallet.getNumberOfBuyAvailableLottoTicket()).boxed()
                .map(n -> lottoMachine.publish())
                .collect(Collectors.toList()));
    }

    public GameResult result(LottoTickets lottoTickets, ResultLotto resultLotto) {
        return lottoTickets.result(resultLotto);
    }
}
