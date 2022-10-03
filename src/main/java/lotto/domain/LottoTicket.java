package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final String ILLEGAL_NUMBERS_SIZE_EXCEPTION_MESSAGE = "로또 티켓 내의 로또 번호는 6개여야 합니다.";
    private static final String NOT_UNIQUE_NUMBERS_EXCEPTION_MESSAGE = "로또 숫자는 중복이 없어야 합니다.";

    private final String ticketId;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.ticketId = UUID.randomUUID().toString();
        this.lottoNumbers = lottoNumbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ILLEGAL_NUMBERS_SIZE_EXCEPTION_MESSAGE);
        }

        if (getUniqueNumbers(lottoNumbers).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(NOT_UNIQUE_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private List<LottoNumber> getUniqueNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
            .distinct()
            .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoTicket that = (LottoTicket)o;
        return Objects.equals(ticketId, that.ticketId) && Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, lottoNumbers);
    }
}
