package lottery.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lottery.LottoConstants;
import org.apache.commons.collections4.CollectionUtils;

public class LottoTicket {

    private static final String ILLEGAL_TICKET_SIZE = "유효하지 않은 티켓입니다.(입력한 숫자가 6개가 아닙니다.)";
    private static final String ILLEGAL_TICKET_NUMBER = "유효하지 않은 티켓입니다.(유요하지 않은 숫자가 입력되었습니다.)";
    private static final String NUMBER_DELIMITER = ", ";
    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = checkTicketValidation(new HashSet<>(lottoNumbers));
    }

    public LottoTicket(Integer... lottoNumber) {
        this(Arrays.asList(lottoNumber));
    }

    public List<Integer> match(List<Integer> winNumbers) {
        return new ArrayList<>(CollectionUtils.intersection(lottoNumbers, winNumbers));
    }

    private List<Integer> checkTicketValidation(Set<Integer> lottoNumbers) {
        if (!isValidSize(lottoNumbers)) {
            throw new IllegalArgumentException(ILLEGAL_TICKET_SIZE);
        }

        if (!isValidNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(ILLEGAL_TICKET_NUMBER);
        }

        return convertSortedNumber(new ArrayList<>(lottoNumbers));
    }

    private List<Integer> convertSortedNumber(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private boolean isValidNumbers(Set<Integer> lottoNumbers) {
        return LottoConstants.LOTTO_NUMBERS.containsAll(lottoNumbers);
    }

    private boolean isValidSize(Set<Integer> lottoNumbers) {
        return lottoNumbers.size() == LottoConstants.LOTTO_TICKER_SIZE;
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

        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(NUMBER_DELIMITER)) + "]";
    }
}
