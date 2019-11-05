package lottery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final Integer LOTTO_TICKER_SIZE = 6;
    private static final Predicate<Integer> LOTTO_VALID_NUMBER_RANGE = integer -> (0 < integer) && (integer < 46);
    private static final String ILLEGAL_TICKET_SIZE = "유효하지 않은 티켓입니다.(입력한 숫자가 6개가 아닙니다.)";
    private static final String ILLEGAL_TICKET_NUMBER = "유효하지 않은 티켓입니다.(유요하지 않은 숫자가 입력되었습니다.)";
    private static final String NUMBER_DELIMITER = ", ";
    private Set<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = checkTicketValidation(new HashSet<>(lottoNumbers));
    }

    public LottoTicket(Integer... lottoNumber) {
        this(Arrays.asList(lottoNumber));
    }

    private Set<Integer> checkTicketValidation(Set<Integer> lottoNumbers) {
        if (!isValidSize(lottoNumbers)) {
            throw new IllegalArgumentException(ILLEGAL_TICKET_SIZE);
        }

        if (!isValidNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(ILLEGAL_TICKET_NUMBER);
        }

        return lottoNumbers;
    }

    private boolean isValidNumbers(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .allMatch(LOTTO_VALID_NUMBER_RANGE);
    }

    private boolean isValidSize(Set<Integer> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_TICKER_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoTicket that = (LottoTicket) o;

        return lottoNumbers != null ? lottoNumbers.equals(that.lottoNumbers) : that.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(NUMBER_DELIMITER));
    }
}
