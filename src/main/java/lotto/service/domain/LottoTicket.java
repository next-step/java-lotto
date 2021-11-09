package lotto.service.domain;

import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private static final Integer MINIMUM_SIZE = 1;
    private static final Integer MAXIMUM_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        Preconditions.checkNotNull(lottoNumbers, "lottoNumbers는 필수값 입니다.");
        Preconditions.checkMinimumNumber(lottoNumbers.size(), MINIMUM_SIZE,
                                         String.format("LottoNumber 갯수는 %s 이상이어야 합니다.", MINIMUM_SIZE));
        Preconditions.checkMaximumNumber(lottoNumbers.size(), MAXIMUM_SIZE,
                                         String.format("LottoNumber 갯수는 %s 이하이어야 합니다.", MAXIMUM_SIZE));

        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public Integer getCountOfMatch(LottoTicket winningLottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(winningLottoTicket.lottoNumbers::contains)
                .count();
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

    @Override
    public String toString() {
        return String.join(", ", lottoNumbers.toString());
    }
}
