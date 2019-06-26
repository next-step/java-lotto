package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
    static final String ALERT_NUMBER_OVERLAP = "중복된 로또 번호가 존재합니다.";
    static final String AlERT_DIFFERENT_SIZE_OF_NUMBERS = "로또번호의 개수가 6개가 아닙니다.";

    private final List<LottoNumber> lottoTicket;

    LottoTicket(List<LottoNumber> lottoTicket) {
        validationNumberSize(lottoTicket);
        validationNumberOverlap(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public int getNumberOfMatchedToLuckyNumber(LottoTicket luckyNumber) {
        return (int) luckyNumber.getLottoTicket().stream()
                .filter(lottoTicket::contains)
                .count();
    }

    private void validationNumberSize(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LottoTicketGenerator.BASIC_LOTTO_SIZE) {
            throw new IllegalArgumentException(AlERT_DIFFERENT_SIZE_OF_NUMBERS);
        }
    }
    private void validationNumberOverlap(List<LottoNumber> lottoTicket) {
        long SizeOfLottoTicket = lottoTicket.stream()
                .mapToLong(LottoNumber::getNumber)
                .distinct()
                .count();

        if (SizeOfLottoTicket != LottoTicketGenerator.BASIC_LOTTO_SIZE) {
            throw new IllegalArgumentException(ALERT_NUMBER_OVERLAP);
        }
    }

    public List<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "lottoTicket=" + lottoTicket +
                '}';
    }
}
