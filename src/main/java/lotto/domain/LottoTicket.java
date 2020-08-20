package lotto.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LinkedHashSet<>(lottoNumbers);
        validate();
    }

    public static LottoTicket of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                                                .map(LottoNumber::new)
                                                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }

    public int getCountOfMatch(LottoTicket otherLottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(otherLottoTicket::isContainNumber)
                .count();
    }

    public boolean isContainNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private void validate() {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                    .map(LottoNumber::toString)
                    .collect(Collectors.joining(","))
                + "]";
    }
}
