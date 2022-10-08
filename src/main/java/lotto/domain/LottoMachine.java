package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.exception.InvalidPurchasePriceException;
import lotto.domain.number.LottoBall;
import lotto.domain.number.LottoBalls;
import lotto.domain.number.Ticket;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public static TicketBox getAutomaticTickets(PurchasePrice purchasePrice) {
        return new TicketBox(IntStream.range(0, getTicketCount(purchasePrice))
                .mapToObj(i -> extractNumbers(intNumbers()))
                .collect(Collectors.toUnmodifiableList()));
    }

    private static int getTicketCount(PurchasePrice purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return purchasePrice.getPrice() / LOTTO_PRICE;
    }

    private static void validatePurchasePrice(PurchasePrice purchasePrice) {
        if (purchasePrice.getPrice() < LOTTO_PRICE) {
            throw new InvalidPurchasePriceException();
        }
    }

    private static List<Integer> intNumbers() {
        List<Integer> numbers = IntStream.range(
                        LottoBall.getFirstOfNumberRange(),
                        LottoBall.getLastOfNumberRange() + 1
                )
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers;
    }

    private static Ticket extractNumbers(List<Integer> numbers) {
        List<Integer> extractedNumbers = numbers.subList(0, LottoBalls.getBallsSize());

        return new Ticket(
                new LottoBalls(
                        extractedNumbers.stream()
                                .map(LottoBall::new)
                                .collect(Collectors.toUnmodifiableList())
                ));
    }

}
