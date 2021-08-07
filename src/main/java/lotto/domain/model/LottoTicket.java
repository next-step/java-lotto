package lotto.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lotto.exception.InvalidLottoTicketException;

public class LottoTicket {

    public static final String COMMA_SPACE_DELIMITER = "\\s*,\\s*";
    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(Set<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket of(List<LottoNumber> lottoNumbers) {
        TreeSet<LottoNumber> lottoNumbersSet = new TreeSet<>(lottoNumbers);
        return new LottoTicket(lottoNumbersSet);
    }

    public static LottoTicket of(String text) {
        String[] tokens = text.split(COMMA_SPACE_DELIMITER);
        List<LottoNumber> lottoNumbers = Arrays.stream(tokens)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return of(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatches(LottoTicket winningTicket) {
        // safe to downcast since LOTTO_SIZE == 6
        return (int) lottoNumbers.stream()
                .filter(winningTicket::contains)
                .count();
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoTicketException();
        }
    }

    public List<Integer> toInts() {
        return lottoNumbers.stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList());
    }
}
