package lotto.domain.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;
    public static final String SIZE_OR_DUPLICATE = "숫자의 개수가 맞지 않거나 반복된 수가 있습니다.";

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateSizeAndDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<LottoNumber> lottoNumbers) {
        TreeSet<LottoNumber> lottoNumbersSet = new TreeSet<>(lottoNumbers);
        return new LottoTicket(lottoNumbersSet);
    }

//    public static LottoTicket of()

    public static LottoTicket createFromList(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(TreeSet::new));
        return new LottoTicket(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private int countMatches(LottoTicket winningTicket) {
        // no loss of data from casting to int since LOTTO_SIZE == 6
        return (int) lottoNumbers.stream().filter(winningTicket::contains).count();
    }

    public LottoRank findRank(LottoTicket winningTicket) {
        int countOfMatch = countMatches(winningTicket);
        return LottoRank.valueOf(countOfMatch);
    }

    private void validateSizeAndDuplicate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_OR_DUPLICATE);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
