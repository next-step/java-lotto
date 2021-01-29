package lotto.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.NUM_LEFT_BOUND;
import static lotto.domain.LottoNumber.NUM_RIGHT_BOUND;
import static lotto.domain.LottoTicket.TICKET_LENGTH;

public class LottoTicketGenerator {
    private static final String MANUAL_NUMBER_DELIMITER = ", ";
    private static List<LottoNumber> candidateNumbers;

    static {
        candidateNumbers = IntStream.range(
            NUM_LEFT_BOUND, NUM_RIGHT_BOUND + 1
        ).mapToObj(
            i -> new LottoNumber(i)
        ).collect(
            Collectors.toList()
        );
    }

    public static LottoTicket generateRandomTicket() {
        Collections.shuffle(candidateNumbers);
        List<LottoNumber> numbers = new ArrayList<>(
            candidateNumbers.subList(0, TICKET_LENGTH)
        );
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }

    public static LottoTicket generateManualTicket(String manualNumbers) {
        return new LottoTicket(
            Arrays.stream(
                manualNumbers.split(MANUAL_NUMBER_DELIMITER)
            ).map(
                manualNumber -> new LottoNumber(manualNumber)
            ).collect(
                Collectors.toList()
            )
        );
    }
}
