package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int TICKET_AMOUNT = 1000;

    private static final int RANGE_BEGIN_NUMBER = 1;
    private static final int RANGE_END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;
    private final int ticketCount;



    public Lotto(int amount) {
        this.ticketCount = convertAmountToTicketCount(amount);
    }

    public static int convertAmountToTicketCount(int amount) {
        return amount / TICKET_AMOUNT;
    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoRangeNumbers = IntStream.range(RANGE_BEGIN_NUMBER, RANGE_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoRangeNumbers);
        lottoRangeNumbers = lottoRangeNumbers.stream()
                .limit(NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
        return lottoRangeNumbers;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
