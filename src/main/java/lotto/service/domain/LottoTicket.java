package lotto.service.domain;

import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.rule.LottoRule.LOTTO_NUMBER_COUNT;

public class LottoTicket {
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        Preconditions.checkNotNull(lottoNumbers, "lottoNumbers는 필수값 입니다.");
        Preconditions.checkSize(lottoNumbers.size(), LOTTO_NUMBER_COUNT,
                                String.format("LottoNumber 갯수는 %s 이어야 합니다.", LOTTO_NUMBER_COUNT));

        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<LottoNumber> numbers) {
        return new LottoTicket(new HashSet<>(numbers));
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Integer getCountOfMatch(LottoTicket lottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(lottoTicket::isContains)
                .count();
    }

    public String getLottoNumbersToString() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
