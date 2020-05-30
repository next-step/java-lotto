package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int DEFAULT_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new NullPointerException();
        }
        validate(lottoNumbers);
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    public static LottoTicket of(Set<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket of(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new NullPointerException();
        }
        return of(
                lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet())
        );
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(Integer number) {
        return lottoNumbers.contains(LottoNumber.of(number));
    }

    private void validate(Set lottoSet) {
        validateSize(lottoSet.size());
    }

    private void validateSize(int size) {
        if (size < DEFAULT_SIZE) {
            throw new IllegalArgumentException("로또 번호의 개수가 알맞지 않습니다.");
        }
    }
}
