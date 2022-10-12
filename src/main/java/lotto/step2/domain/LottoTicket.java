package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final String EXCEEDED_NUMBER_OF_LOTTO_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 6개까지만 가질 수 있습니다.";
    private static final int MAX_COUNT_OF_LOTTO_NUMBER = 6;
    
    private final List<LottoNumber> lottoTicket;
    
    public LottoTicket(List<LottoNumber> lottoTicket) {
        if (lottoTicket.size() > MAX_COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(EXCEEDED_NUMBER_OF_LOTTO_NUMBERS_EXCEPTION_MESSAGE);
        }
        this.lottoTicket = lottoTicket;
    }
    
    public LottoTicket(String lottoTicket) {
        this.lottoTicket = getLottoNumbers(lottoTicket);
    }
    
    private List<LottoNumber> getLottoNumbers(final String lottoTicket) {
        return Arrays.stream(split(removeSpace(lottoTicket)))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
    
    private String[] split(final String removeSpace) {
        return removeSpace.split(",");
    }
    
    private String removeSpace(final String lottoTicket) {
        return lottoTicket.replace(" ", "");
    }
    
    public int countMatchingNumber(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.countMatchingNumber(lottoTicket);
    }
    
    public boolean isExistBonusLottoNumber(WinningLottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.isExistBonusLottoNumber(lottoTicket);
    }
    
    public List<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket);
    }
}
