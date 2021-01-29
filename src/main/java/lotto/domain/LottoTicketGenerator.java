package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.NUM_LEFT_BOUND;
import static lotto.domain.LottoNumber.NUM_RIGHT_BOUND;
import static lotto.domain.LottoTicket.TICKET_LENGTH;

public class LottoTicketGenerator {
    private static final String MANUAL_NUMBER_DELIMITER = ", ";
    private static List<LottoNumber> candidateNumbers = new ArrayList<>();

    static {
        for (int i = NUM_LEFT_BOUND; i <= NUM_RIGHT_BOUND; i++) {
            candidateNumbers.add(new LottoNumber(i));
        }
    }

    public static LottoTicket generateRandomTicket() {
        Collections.shuffle(candidateNumbers);
        List<LottoNumber> numbers = candidateNumbers.subList(0, TICKET_LENGTH);
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }

    public static LottoTicket generateManualTicket(String manualNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (String manualNumber : manualNumbers.split(MANUAL_NUMBER_DELIMITER)) {
            numbers.add(new LottoNumber(manualNumber));
        }
        return new LottoTicket(numbers);
    }
}
