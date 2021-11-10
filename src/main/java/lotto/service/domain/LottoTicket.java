package lotto.service.domain;

import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final Integer LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        Preconditions.checkNotNull(lottoNumbers, "lottoNumbers는 필수값 입니다.");
        Preconditions.checkSize(lottoNumbers.size(), LOTTO_NUMBERS_SIZE,
                                String.format("LottoNumber 갯수는 %s 이어야 합니다.", LOTTO_NUMBERS_SIZE));

        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
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
