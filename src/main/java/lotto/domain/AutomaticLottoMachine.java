package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.number.LottoBall;
import lotto.domain.number.LottoBalls;
import lotto.domain.number.Ticket;

public class AutomaticLottoMachine implements LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public TicketBox issueTickets(PurchasePrice purchasePrice) {
        return new TicketBox(IntStream.range(0, getTicketCount(purchasePrice))
                .mapToObj(i -> extractNumbers(intNumbers()))
                .collect(Collectors.toUnmodifiableList()));
    }

    @Override
    public int getLottoPrice() {
        return LOTTO_PRICE;
    }

    private List<Integer> intNumbers() {
        List<Integer> numbers = IntStream.range(
                        LottoBall.getFirstOfNumberRange(),
                        LottoBall.getLastOfNumberRange() + 1
                )
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers;
    }

    private Ticket extractNumbers(List<Integer> numbers) {
        List<Integer> extractedNumbers = numbers.subList(0, LottoBalls.getBallsSize());

        return new Ticket(
                new LottoBalls(
                        extractedNumbers.stream()
                                .map(LottoBall::new)
                                .collect(Collectors.toUnmodifiableList())
                ));
    }

}
