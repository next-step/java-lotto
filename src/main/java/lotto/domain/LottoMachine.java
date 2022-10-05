package lotto.domain;

import static lotto.domain.number.LottoNumbers.FIRST_NUMBER;
import static lotto.domain.number.LottoNumbers.LAST_NUMBER;
import static lotto.domain.number.LottoNumbers.LOTTO_NUMBERS_SIZE;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.exception.InvalidPurchasePriceException;
import lotto.domain.number.Ticket;
import lotto.domain.number.WinningNumbers;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public static TicketBox getAutomaticTickets(int purchasePrice) {
        return new TicketBox(IntStream.range(0, getTicketCount(purchasePrice))
                .mapToObj(i -> extractNumbers(intNumbers()))
                .collect(Collectors.toUnmodifiableList()));
    }

    public static int getMatchingNumberCount(WinningNumbers winningNumbers, Ticket ticket) {
        int count = 0;
        for (Integer number : ticket.getNumbers()) {
            count += determineMatch(winningNumbers, number);
        }
        return count;
    }

    private static int getTicketCount(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return purchasePrice / LOTTO_PRICE;
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) {
            throw new InvalidPurchasePriceException();
        }
    }

    private static List<Integer> intNumbers() {
        List<Integer> numbers = IntStream.range(FIRST_NUMBER, LAST_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers;
    }

    private static Ticket extractNumbers(List<Integer> numbers) {
        List<Integer> extractedNumbers = numbers.subList(0, LOTTO_NUMBERS_SIZE);
        Collections.sort(extractedNumbers);
        return new Ticket(extractedNumbers);
    }

    private static int determineMatch(WinningNumbers winningNumbers, int number) {
        if (winningNumbers.contain(number)) {
            return 1;
        }
        return 0;
    }

}
