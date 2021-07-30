package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int TICKET_SIZE = 6;
    public static final String SIZE_EXCEPTION = "로또 티켓은 " + TICKET_SIZE + "개의 숫자가 필요합니다.";
    public static final String DUPLICATE_EXCEPTION = "반복된 숫자가 로또 티켓에 있습니다.";

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    public static LottoTicket createFromList(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }

    private static void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumbersSet = new HashSet<>(lottoNumbers);
        if (lottoNumbersSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private static void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != TICKET_SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private int countMatches(LottoTicket winningTicket) {
        // no loss of data from casting to int since TICKET_SIZE == 6
        return (int) lottoNumbers.stream().filter(winningTicket::contains).count();
    }

    public Rank findRank(LottoTicket winningTicket) {
        int countOfMatch = countMatches(winningTicket);
        return Rank.valueOf(countOfMatch);
    }
}
