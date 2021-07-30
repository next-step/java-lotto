package lotto.domain.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;
    public static final String SIZE_OR_DUPLICATE_EXCEPTION = "숫자의 개수가 맞지 않거나 반복된 수가 있습니다.";

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        validateSizeAndDuplicate(this.lottoNumbers);
    }

    private void validateSizeAndDuplicate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_OR_DUPLICATE_EXCEPTION);
        }
    }

    public static LottoTicket createFromList(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatches(LottoTicket winningTicket) {
        // no loss of data from casting to int since LOTTO_SIZE == 6
        return (int) lottoNumbers.stream().filter(winningTicket::contains).count();
    }

    public Rank findRank(LottoTicket winningTicket) {
        int countOfMatch = countMatches(winningTicket);
        return Rank.valueOf(countOfMatch);
    }
}
