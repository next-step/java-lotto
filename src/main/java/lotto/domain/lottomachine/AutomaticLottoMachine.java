package lotto.domain.lottomachine;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.number.LottoBall;
import lotto.domain.number.LottoBalls;
import lotto.domain.number.Ticket;

public class AutomaticLottoMachine implements LottoMachine {

    private final List<Integer> numbers = intNumbers();

    public TicketBox issueTickets(PurchasePrice purchasePrice) {
        return new TicketBox(IntStream.range(0, getTicketCount(purchasePrice, Ticket.getPrice()))
                .mapToObj(i -> extractNumbers())
                .collect(Collectors.toUnmodifiableList()));
    }

    private List<Integer> intNumbers() {
        return IntStream.range(
                        LottoBall.getFirstOfNumberRange(),
                        LottoBall.getLastOfNumberRange() + 1
                )
                .boxed()
                .collect(Collectors.toList());
    }

    private Ticket extractNumbers() {
        Collections.shuffle(numbers);
        List<Integer> extractedNumbers = numbers.subList(0, LottoBalls.getBallsSize());

        return new Ticket(
                new LottoBalls(
                        extractedNumbers.stream()
                                .map(LottoBall::of)
                                .collect(Collectors.toUnmodifiableList())
                ));
    }

}
