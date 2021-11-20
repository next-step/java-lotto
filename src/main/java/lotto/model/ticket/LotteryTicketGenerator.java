package lotto.model.ticket;

import lotto.model.domain.Lotto;
import lotto.model.game.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicketGenerator {

    private static final List<Lotto> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER,LottoNumber.MAX_NUMBER)
                                                        .boxed().map(Lotto::new).collect(Collectors.toList());

    public static LotteryTicket generate() {
        List<Lotto> chosenNumbers = chooseNumber();
        return new LotteryTicket(chosenNumbers);
    }

    private static List<Lotto> chooseNumber() {
        Collections.shuffle(numbers);
        List<Lotto> chosenNumbers = numbers.stream()
                                            .limit(LottoNumber.CHOOSE_COUNT)
                                            .collect(Collectors.toList());
        Collections.sort(chosenNumbers);
        return chosenNumbers;
    }
}