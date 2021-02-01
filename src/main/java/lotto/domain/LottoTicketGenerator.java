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
    private static final String PARSE_ERROR_MESSAGE = "로또 번호 입력은 (%s)를 구분자로 한 6개의 숫자여야 합니다";
    private static final String MANUAL_NUMBER_DELIMITER = ", ";
    private static final List<LottoNumber> candidateNumbers;

    static {
        candidateNumbers = IntStream.range(
            NUM_LEFT_BOUND, NUM_RIGHT_BOUND + 1
        ).mapToObj(
            LottoNumber::new
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
        try {
            return new LottoTicket(
                Arrays.stream(
                    manualNumbers.split(MANUAL_NUMBER_DELIMITER)
                ).map(
                    LottoNumber::new
                ).collect(
                    Collectors.toList()
                )
            );
        } catch (NumberFormatException e) {
            throw new RuntimeException(PARSE_ERROR_MESSAGE);
        }
    }
}
