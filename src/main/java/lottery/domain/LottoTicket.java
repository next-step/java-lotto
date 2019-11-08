package lottery.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

public class LottoTicket {

    public static final Integer TICKET_PRICE = 1000;
    private static final Integer LOTTO_TICKER_SIZE = 6;
    private static final String ILLEGAL_TICKET_SIZE = "유효하지 않은 티켓입니다.(입력한 숫자가 6개가 아닙니다.)";
    private static final String NUMBER_DELIMITER = ", ";
    private List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(Integer... lottoNumbers) {
        return LottoTicket.ofIntegerList(Arrays.asList(lottoNumbers));
    }

    public static LottoTicket ofIntegerList(List<Integer> lottoNumbers) {
        return LottoTicket.ofLottoNumberList(LottoNumber.ofNumbers(checkTicketValidation(new HashSet<>(lottoNumbers))));
    }

    public static LottoTicket ofLottoNumberList(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket ofRandom() {
        return LottoTicket.ofLottoNumberList(LottoNumber.ofRandom(LOTTO_TICKER_SIZE));
    }

    public List<LottoNumber> match(LottoTicket winLottoTicket) {
        return winLottoTicket.getMatchedNumbers(this, winLottoTicket);
    }

    public boolean isBonusMatched(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private List<LottoNumber> getMatchedNumbers(LottoTicket ticket1, LottoTicket ticket2) {
        return new ArrayList<>(CollectionUtils.intersection(ticket1.lottoNumbers, ticket2.lottoNumbers));
    }

    private static List<Integer> checkTicketValidation(Set<Integer> lottoNumbers) {
        if (!isValidSize(lottoNumbers)) {
            throw new IllegalArgumentException(ILLEGAL_TICKET_SIZE);
        }

        return convertSortedNumber(new ArrayList<>(lottoNumbers));
    }

    private static List<Integer> convertSortedNumber(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static boolean isValidSize(Set<Integer> lottoNumbers) {
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

        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
            .map(LottoNumber::toString)
            .collect(Collectors.joining(NUMBER_DELIMITER)) + "]";
    }
}
