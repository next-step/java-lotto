package lotto.step2.domain;

import lotto.step2.dto.LottoTicketDTO;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private static final String EXCEEDED_NUMBER_OF_LOTTO_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 6개까지만 가질 수 있습니다.";
    
    private final List<LottoNumber> lottoTicket;
    
    public LottoTicket(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() > 6) {
            throw new IllegalArgumentException(EXCEEDED_NUMBER_OF_LOTTO_NUMBERS_EXCEPTION_MESSAGE);
        }
        this.lottoTicket = lottoTicket;
    }
    
    public int countMatchingNumber(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.countMatchingNumber(lottoTicket);
    }
    
    public LottoTicketDTO lottoTicketInformation() {
        return new LottoTicketDTO(lottoTicket);
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
}
