package lotto.model.ticket.generator;

import lotto.model.domain.Lotto;
import lotto.model.game.LottoNumber;
import lotto.model.ticket.LotteryTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoTicketGenerator implements LotteryTicketGenerator {

    private static final List<Lotto> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER,LottoNumber.MAX_NUMBER)
            .boxed().map(Lotto::new)
            .collect(Collectors.toList());

    private List<Lotto> chooseNumber() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LottoNumber.CHOOSE_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public LotteryTicket generate() {
        return new LotteryTicket(chooseNumber());
    }
}